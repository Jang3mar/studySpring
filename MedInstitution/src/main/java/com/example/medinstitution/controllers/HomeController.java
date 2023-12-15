package com.example.medinstitution.controllers;

import com.example.medinstitution.models.*;
import com.example.medinstitution.models.plugs.EmpPositionForDoctorInfo;
import com.example.medinstitution.models.plugs.EmpPositionInfo;
import com.example.medinstitution.models.plugs.Registation_Info;
import com.example.medinstitution.models.views.read_all_receptions;
import com.example.medinstitution.models.views.read_all_registrations;
import com.example.medinstitution.utilities.APIInterface;
import com.example.medinstitution.utilities.RequestBuilder;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getAutho(Model model) {
        return "AuthorisationWin";
    }

    @GetMapping("/AuthorisationWin/RegistrationWin")
    public String getRegistration() {
        return "RegistrationWin";
    }

//    @GetMapping("/SysAdminMenu")
//    public String getSysAdmin() {return "SysAdminMenu";}


    @GetMapping("/PatientMenu")
    public String getPatientMenu(Model model, @RequestParam(value = "typesFilter", required = false) String types){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            List<read_all_registrations> readAllRegs = api.readAllRegistrations().execute().body();
            List<DepartmentMed> departmentList = api.getListDepartment().execute().body();
//            Logger.getAnonymousLogger().info(readAllRegs.size()+"");
//            Logger.getAnonymousLogger().info(readAllRegs.get(0).getId_patient().toString());
            readAllRegs = readAllRegs.stream().filter(readAllRegistrations -> readAllRegistrations.getId_patient() == 0).toList();
            Logger.getAnonymousLogger().info(types);
            if(types != null && !types.isEmpty()){
                Logger.getAnonymousLogger().info("Im here");
                types = types.substring(0, types.length()-1);
                String[] typeArr = types.split(",");
                List<read_all_registrations> resList = new ArrayList<>();
                Logger.getAnonymousLogger().info(typeArr[0]);
                for (read_all_registrations info: readAllRegs) {
                    for(int i = 0; i< typeArr.length;i++){
                        if(info.getDepartments().toLowerCase().contains(typeArr[i].toLowerCase())){
                            resList.add(info);
                            break;
                        }
                    }
                }
                readAllRegs = resList;
            }
            model.addAttribute("regs", readAllRegs);
            model.addAttribute("listDepartment", departmentList);
            Logger.getAnonymousLogger().info(readAllRegs.size()+"");
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());};
        return "PatientMenu";
    }

    @GetMapping("/PatientMenu/Search")
    public String getPatientMenuSearch(Model model, @RequestParam("SFM") String SFM){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            List<Registration> PE = api.getRegistrarions().execute().body();
            List<EmpPositionInfo> epInfo = new ArrayList<>();
            List<Position_Employee> posit = api.getListPosEmp().execute().body();
            for (Registration reg: PE) {
                epInfo.add(new EmpPositionInfo(
                        reg.getID_Employee(),
                        reg.getDate_Reg()+" "+reg.getTime_Reg(),
                        posit.stream().filter(positionEmployee -> positionEmployee.getID_Emp_Pos().getID_Employee() == reg.getID_Employee().getID_Employee()).toList()
                        ));
            }
            epInfo = epInfo.stream().filter(empPositionInfo -> {
                Logger.getAnonymousLogger().info(empPositionInfo.empFIO.toLowerCase()+" "+SFM.toLowerCase());
                return empPositionInfo.empFIO.toLowerCase().contains(SFM.toLowerCase());
            }).toList();
            model.addAttribute("regs", epInfo);
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());};
        return "PatientMenu";
    }

    @GetMapping("/ReceptionWinList")
    private String getPastReceptionsPat(Model model){
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            List<read_all_receptions> listReceptions = api.readAllReceptions().execute().body();
//            Logger.getAnonymousLogger().info(res.body().get(0).getDepartment_Name());
            model.addAttribute("receptionsList", listReceptions);
        } catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "ReceptionWinList";
    }

    @GetMapping("/PrivateRoom")
    public String getPrivateRoom(Model model, @CookieValue("userId") String id ) throws IOException {
        APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
        Patient curPatient = api.getPatient(Long.parseLong(id)).execute().body();
        Document doc = api.getDocumentId(Long.parseLong(id)).execute().body();
        LocalDateTime ldt = LocalDateTime.now();
        if(doc != null){
            model.addAttribute("docs", doc);
        }
        model.addAttribute("patient", curPatient);
        return "PrivateRoom";
    }
    @PostMapping("/PrivateRoom/AddDocument")
    public String getPrivateRoom( @CookieValue("userId") String id,
                                  @RequestParam("SeriesPassport") String seriesPassport,
                                  @RequestParam("NumPassport") String numPassport,
                                  @RequestParam("DateIssue") LocalDateTime dateIssue,
                                  @RequestParam("IssuedBy") String issuedBy,
                                  @RequestParam("DepCode") String depCode,
                                  @RequestParam("NumCMI") String numCMI
                                  ) throws IOException {
        APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
        Patient curPatient = api.getPatient(Long.parseLong(id)).execute().body();
        String date = dateIssue.getDayOfMonth()+"."+dateIssue.getMonthValue()+"."+dateIssue.getYear();
        Document document = new Document(0L,seriesPassport,numPassport,date,depCode,issuedBy,numCMI, curPatient);
        api.addDocument(document).execute();
        return "redirect:/PrivateRoom";
    }

    @GetMapping("/RegistrationsList")
    private String getRegistrationsList(Model model, @CookieValue("userId") String userId){
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            List<read_all_registrations> registrations = api.readAllRegistrations().execute().body();
            registrations = registrations.stream().filter(reg -> reg.getId_patient() == Long.parseLong(userId)).toList();
            model.addAttribute("regList", registrations);
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return "RegistrationsList";
    }

    @PostMapping("/addSymptoms")
    private String updateRegsInfo(@RequestParam("idReg") Long idReg, @RequestParam("des_symptoms") String des_symptoms){
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<Registration> updateReg = api.returnRegistrationId(idReg);
            Registration registration = updateReg.execute().body();
            registration.setDes_Symptoms(des_symptoms);
            Call<Registration> updateExec = api.updateRegistration(idReg, registration);
            updateExec.execute();
            Logger.getAnonymousLogger().info("AAAAAAAAAAAAAAA");
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return "redirect:/RegistrationsList";
    }

    @GetMapping("/EmployeeMenu")
    public String getEmployeeMenu(Model model, @CookieValue("userId") String id) {
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            List<Registration> registrations = api.getListRegistrarions().execute().body();
            registrations = registrations.stream().filter(reg -> reg.getID_Employee().getID_Employee() == Long.parseLong(id)).toList();
            List<EmpPositionForDoctorInfo> allInfo = new ArrayList<>();
            for (Registration registration : registrations) {
                EmpPositionForDoctorInfo info = new EmpPositionForDoctorInfo(registration.getID_Patient(), registration.getDate_Reg(), registration.getTime_Reg());
                allInfo.add(info);
            }
            if (allInfo.isEmpty()) {
                allInfo.add(new EmpPositionForDoctorInfo(null, "Нет записей.", ""));
            }
            model.addAttribute("registrations", allInfo);
            return "EmployeeMenu";
        }
        catch (Exception e ) {
            Logger.getAnonymousLogger().info(e.getMessage());
            return "";
        }
    }

    @GetMapping("/ReceptionPastEmp")
    private String getReceptionPastEmp(){return "ReceptionPastEmp";}

    @GetMapping("/ReceptionPatWin")
    private String getRecpetionPatWin() {return "ReceptionPatWin";}

    @GetMapping("/PatientRecInfo")
    private String getPatientRecInfo() {return "PatientRecInfo";}

    @GetMapping("/AdminPanel")
    public String getAdmin() {
        return "AdminPanel";
    }


    //--------------------department-----------------------------
//    @GetMapping("/AdminPanel/modelsWin/DepartmentWin")
//    public String getDepartment() {
//        return "modelsWin/DepartmentWin";
//    }

    @GetMapping("/AdminPanel/modelsWin/DepartmentWin")
    public String getDepartment(Model model) {
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<List<DepartmentMed>> listDepartment = api.getListDepartment();
            Response<List<DepartmentMed>> res = listDepartment.execute();
            Logger.getAnonymousLogger().info(res.body().get(0).getDepartment_Name());
            model.addAttribute("departmentList", res.body());
        } catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "modelsWin/DepartmentWin";
    }

    @PostMapping("/AdminPanel/modelsWin/DepartmentWin/addDepartment")
    public String addDepartment(Model model, @RequestParam(name = "departmentName") String departmentName) {
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Logger.getAnonymousLogger().info(departmentName);
            Call<DepartmentMed> newDepartment = api.addDepartment(new DepartmentMed(0l, departmentName));
            newDepartment.execute();
            Call<List<DepartmentMed>> listDepartment = api.getListDepartment();
            Response<List<DepartmentMed>> res = listDepartment.execute();
            //Logger.getAnonymousLogger().info(res.body().get(0).getPosition_Name());
            model.addAttribute("departmentList", res.body());
        }
        catch (Exception e){
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "modelsWin/DepartmentWin";}

    @PostMapping("/AdminPanel/modelsWin/DepartmentWin/updateDepartment")
    public String updateDepartment(Model model, @RequestParam(name = "departmentID") Long id, @RequestParam(name = "departmentName") String departmentName){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<DepartmentMed> newDepartment = api.updateDepartment(id, new DepartmentMed(id, departmentName));
            newDepartment.execute();
            Call<List<DepartmentMed>> listDepartment = api.getListDepartment();
            Response<List<DepartmentMed>> res = listDepartment.execute();
            model.addAttribute("departmentList", res.body());
        }
        catch (Exception e) {}
        return "modelsWin/DepartmentWin";
    }

    @PostMapping("/AdminPanel/modelsWin/DepartmentWin/deleteDepartment")
    public String deleteDepartment(Model model, @RequestParam(name = "departmentID") Long id){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<DepartmentMed> newDepartment = api.deleteDepartment(id);
            newDepartment.execute();
            Call<List<DepartmentMed>> listDepartment = api.getListDepartment();
            Response<List<DepartmentMed>> res = listDepartment.execute();
            model.addAttribute("departmentList", res.body());
        }
        catch (Exception e) {}
        return "modelsWin/DepartmentWin";
    }
    //---------------------------------------------------------------


    @GetMapping("/AdminPanel/modelsWin/DiagnosisWin")
    public String getDiagnosis() {
        return "modelsWin/DiagnosisWin";
    }

    @GetMapping("/AdminPanel/modelsWin/DocumentWin")
    public String getDocument() {
        return "modelsWin/DocumentWin";
    }

    @GetMapping("/AdminPanel/modelsWin/EducationEmployeeWin")
    public String getEduEmp() {
        return "modelsWin/EducationEmployeeWin";
    }

    @GetMapping("/AdminPanel/modelsWin/EducationWin")
    public String getEducation() {
        return "modelsWin/EducationWin";
    }

    @GetMapping("/AdminPanel/modelsWin/EmployeeWin")
    public String getEmployee(Model model) {
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<List<Employee>> listEmployee = api.getListEmployee();
            Response<List<Employee>> res = listEmployee.execute();
//            Logger.getAnonymousLogger().info(res.body().get(0).getDepartment_Name());
            model.addAttribute("employeeList", res.body());
        } catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "modelsWin/EmployeeWin";
    }
    @PostMapping("/AdminPanel/modelsWin/EmployeeWin")
    public String addEmployee(Model model, @RequestParam(name = "Second_Employee") String Second_Employee,
                              @RequestParam(name = "First_Employee") String First_Employee,
                              @RequestParam(name = "Middle_Employee") String Middle_Employee,
                              @RequestParam(name = "Birthday_Employee") String Birthday_Employee,
                              @RequestParam(name = "Login_Employee") String Login_Employee,
                              @RequestParam(name = "Password_Employee") String Password_Employee) {
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
//            Logger.getAnonymousLogger().info(positionName);
            Call<Employee> newEmployee = api.addEmployee(new Employee(0l, Second_Employee, First_Employee, Middle_Employee, Birthday_Employee, Login_Employee, Password_Employee));
            newEmployee.execute();
            Call<List<Employee>> listEmployee = api.getListEmployee();
            Response<List<Employee>> res = listEmployee.execute();
//            Logger.getAnonymousLogger().info(res.body().get(0).getPosition_Name());
            model.addAttribute("employeeList", res.body());
        }
        catch (Exception e){
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "modelsWin/EmployeeWin";}

    @GetMapping("/AdminPanel/modelsWin/EmployeeDepWin")
    public String getEmployeeDep() {
        return "modelsWin/EmployeeDepWin";
    }

    @GetMapping("/AdminPanel/modelsWin/MedicalCardWin")
    public String getMedCard() {
        return "modelsWin/MedicalCardWin";
    }

    @GetMapping("/AdminPanel/modelsWin/MedReferenceWin")
    public String getMedRef() {
        return "modelsWin/MedReferenceWin";
    }

    @GetMapping("/AdminPanel/modelsWin/PatientCardWin")
    public String getPatientCard() {
        return "modelsWin/PatientCardWin";
    }

    @GetMapping("/AdminPanel/modelsWin/PatientCategoryWin")
    public String getPatientCategory() {
        return "modelsWin/PatientCategoryWin";
    }

    @GetMapping("/AdminPanel/modelsWin/PatientWin")
    public String getPatient() {
        return "modelsWin/PatientWin";
    }

    @GetMapping("/AdminPanel/modelsWin/PositionEmpWin")
    public String getPosEmp(Model model) {
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<List<Position>> listPosition = api.getListPosition();
            Call<List<Employee>> listEmployee = api.getListEmployee();
            Call<List<Position_Employee>> listPosEmp = api.getListPosEmp();
            Response<List<Position>> resPos = listPosition.execute();
            Response<List<Employee>> resEmp = listEmployee.execute();
            Response<List<Position_Employee>> resPosEmp = listPosEmp.execute();
            model.addAttribute("positionList", resPos.body());
            model.addAttribute("employeeList", resEmp.body());
            model.addAttribute("posEmpList", resPosEmp.body());
            //Logger.getAnonymousLogger().info(resPosEmp.body().get(0).getID_Emp_Pos().getID_Employee()+"");
            Logger.getAnonymousLogger().info(resPosEmp.body().get(0).getID_Pos_Emp().getPosition_Name());
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return "modelsWin/PositionEmpWin";
    }

    @GetMapping("/AdminPanel/modelsWin/PositionWin")
    public String getPosition(Model model) {
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<List<Position>> listPosition = api.getListPosition();
            Response<List<Position>> res = listPosition.execute();
            Logger.getAnonymousLogger().info(res.body().get(0).getPosition_Name());
            model.addAttribute("positionList", res.body());
        } catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "modelsWin/PositionWin";
    }

    @GetMapping("/AdminPanel/modelsWin/ReceptionWin")
    public String getReception() {
        return "modelsWin/ReceptionWin";
    }

    @GetMapping("/AdminPanel/modelsWin/RegWin")
    public String getReg() {
        return "modelsWin/RegWin";
    }

//    @GetMapping("/PatientMenu/PrivateRoom")
//    public String getPatientPrivate(Model model, @CookieValue(value = "userId") Long userId){
//
//    }

    @PostMapping("/RegistrationWin")
    public String registration(Model model,
                               @RequestParam(name = "secondName") String secondName,
                               @RequestParam(name = "firstName") String firstName,
                               @RequestParam(name = "middleName") String middleName,
                               @RequestParam(name = "loginPatient") String loginPatient,
                               @RequestParam(name = "passwordPatient") String passwordPatient,
                               @RequestParam(name = "birthdayPatient") LocalDateTime birthdayPatient){
        try{
            String errorMessage = "";
            if (secondName.length() >= 50 || secondName.length() < 2){
                errorMessage += " Неверная длина фамилии";
            }
            if (firstName.length() >= 50 || firstName.length() < 2){
                errorMessage += " Неверная длина имени";
            }
            if (middleName.length() >= 50 || middleName.length() < 2){
                errorMessage += " Неверная длина отчества";
            }
            if (birthdayPatient.toEpochSecond(ZoneOffset.UTC) >= LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)){
                errorMessage += " Неверная дата рождения";
            }
            if(loginPatient.length() > 20 || loginPatient.length() < 5){
                errorMessage += " Неверная длина логина";
            }
            if(passwordPatient.length() > 30 || passwordPatient.length() < 5){
                errorMessage += " Неверная длина пароля";
            }
            if(!loginPatient.matches("^.*[a-z].*$") || !loginPatient.matches("^.*[A-Z].*$") || !loginPatient.matches("^.*[0-9].*$") || !loginPatient.matches("^.*[!#$%^&*_].*$")){
                errorMessage += " Логин должен содержать минимум 1 прописную букву, 1 заглавную букву, 1 цифру и 1 спецсимвол";
            }
            if(!passwordPatient.matches("^.*[a-z].*$") || !passwordPatient.matches("^.*[A-Z].*$") || !passwordPatient.matches("^.*[0-9].*$") || !passwordPatient.matches("^.*[!#$%^&*_].*$")){
                errorMessage += " Пароль должен содержать минимум 1 прописную букву, 1 заглавную букву, 1 цифру и 1 спецсимвол";
            }
            if (errorMessage != "") {
                model.addAttribute("error", errorMessage);
            }
            else{
                String regDate = birthdayPatient.getDayOfMonth()+"."+ birthdayPatient.getMonthValue() + "." + birthdayPatient.getYear() ;
                APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
                Call<Patient> newPatient = api.registerPatient(new Patient(0l, secondName, firstName, middleName, loginPatient, passwordPatient, regDate));
                if (newPatient.execute().isSuccessful()){
                    return "redirect:/";
                }
//                Call<List<Patient>> listPatient = api.getListPatient();
//
//                Response<List<Patient>> res = listPatient.execute();
//                model.addAttribute("patientList", res.body());
            }
        }
        catch (Exception e ) {Logger.getAnonymousLogger().info(e.getMessage());}
        return "RegistrationWin";
    }

    @PostMapping("/AdminPanel/modelsWin/PositionWin")
    public String addPosition(Model model, @RequestParam(name = "positionName") String positionName) {
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Logger.getAnonymousLogger().info(positionName);
            Call<Position> newPosition = api.addPosition(new Position(0l, positionName));
            newPosition.execute();
            Call<List<Position>> listPosition = api.getListPosition();
            Response<List<Position>> res = listPosition.execute();
            Logger.getAnonymousLogger().info(res.body().get(0).getPosition_Name());
            model.addAttribute("positionList", res.body());
        }
        catch (Exception e){
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "modelsWin/PositionWin";}

    @PostMapping("/AdminPanel/modelsWin/PositionEmpWin")
    public String addPosEmp(Model model, @RequestParam(name = "positionId") Long posId, @RequestParam(name = "employeeId") Long employeeId) {
        try {
            Logger.getAnonymousLogger().info(posId+" "+employeeId);
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Employee employee = api.getEmployeeId(employeeId).execute().body();
            Position position = api.getPositionId(posId).execute().body();
            Call<Position_Employee> newPosEmp = api.addPosEmp(new Position_Employee(0l, employee, position));
            newPosEmp.execute();
            Call<List<Position>> listPosition = api.getListPosition();
            Call<List<Employee>> listEmployee = api.getListEmployee();
            Call<List<Position_Employee>> listPosEmp = api.getListPosEmp();
            Response<List<Position>> resPos = listPosition.execute();
            Response<List<Employee>> resEmp = listEmployee.execute();
            Response<List<Position_Employee>> resPosEmp = listPosEmp.execute();
            model.addAttribute("positionList", resPos.body());
            model.addAttribute("employeeList", resEmp.body());
            model.addAttribute("posEmpList", resPosEmp.body());
            Logger.getAnonymousLogger().info(resPosEmp.body().get(0).getID_Emp_Pos().getSecond_Employee());
        }
        catch (Exception e){
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "modelsWin/PositionEmpWin";}

    @PostMapping("/AdminPanel/modelsWin/PositionWin/updatePosition")
    public String updatePosition(Model model, @RequestParam(name = "positionID") Long id, @RequestParam(name = "namePosition") String namePosition){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<Position> newPosition = api.updatePosition(id, new Position(id, namePosition));
            newPosition.execute();
            Call<List<Position>> listPosition = api.getListPosition();
            Response<List<Position>> res = listPosition.execute();
            model.addAttribute("positionList", res.body());
        }
        catch (Exception e) {}
        return "modelsWin/PositionWin";
    }

    @PostMapping("/AdminPanel/modelsWin/PositionWin/deletePosition")
    public String deletePosition(Model model, @RequestParam(name = "positionID") Long id){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<Position> newPosition = api.deletePosition(id);
            newPosition.execute();
            Call<List<Position>> listPosition = api.getListPosition();
            Response<List<Position>> res = listPosition.execute();
            model.addAttribute("positionList", res.body());
        }
        catch (Exception e) {}
        return "modelsWin/PositionWin";
    }

    @PostMapping("/AdminPanel/modelsWin/PositionEmpWin/deletePositionEmp")
    public String deletePosEmp(Model model, @RequestParam(name = "posEmpID") Long id){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<Position_Employee> newPosEmp = api.deletePosEmp(id);
            newPosEmp.execute();
            Call<List<Position>> listPosition = api.getListPosition();
            Call<List<Employee>> listEmployee = api.getListEmployee();
            Call<List<Position_Employee>> listPosEmp = api.getListPosEmp();
            Response<List<Position>> resPos = listPosition.execute();
            Response<List<Employee>> resEmp = listEmployee.execute();
            Response<List<Position_Employee>> resPosEmp = listPosEmp.execute();
            model.addAttribute("positionList", resPos.body());
            model.addAttribute("employeeList", resEmp.body());
            model.addAttribute("posEmpList", resPosEmp.body());
            //List<T> oList = api.getListPosition().execute().body(); - полный метод для запроса списка записей в таблице
        }
        catch (Exception e) {}
        return "modelsWin/PositionEmpWin";
    }

    @GetMapping("/AuthorisationWin")
    public String authorisation(Model model,
                                @RequestParam(name = "login") String login,
                                @RequestParam(name = "password") String password,
                                HttpServletResponse httpResponse)
    {
        String returnPage = "AuthorisationWin";
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Map<String, Object> map = api.returnLogIn(login, password).execute().body();
            Logger.getAnonymousLogger().info(login);
            //Logger.getAnonymousLogger().info(password);
            if (map.containsKey("type")){
                String type = String.valueOf(map.get("type"));
                Logger.getAnonymousLogger().info(type);
                if(type.equals("P")){

                    returnPage = "redirect:PatientMenu";
                } else if (type.equals("E")) {
                    returnPage = "redirect:EmployeeMenu";
                } else if (type.equals("S")){
                    returnPage = "redirect:SysAdminMenu";
                }
                else{
                    returnPage = "redirect:AdminPanel";
                }
                float id = Float.parseFloat(String.valueOf(map.get("id")));
                Long newId = Long.valueOf(Math.round(id));
                Cookie cookie = new Cookie("userId", newId + "");
                cookie.setMaxAge(2 * 24 * 60 * 60);
                Logger.getAnonymousLogger().info(cookie.getName() + " " + cookie.getValue());
                httpResponse.addCookie(cookie);
            }
            else{
                model.addAttribute("errorMessage", "Неправильный логин или пароль!");
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        Logger.getAnonymousLogger().info(returnPage);
        return returnPage;
    }

    @GetMapping("/addBackup")
    public String getBackup(){
        APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
        return "";
    }

    @GetMapping("/SysAdminMenu")
    public String getLoggers(Model model){
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<List<Loggers>> listLog = api.getLoggers();
            Response<List<Loggers>> res = listLog.execute();
            Logger.getAnonymousLogger().info(res.body().get(0).getDate_Log());

            model.addAttribute("logs", res.body());
        } catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return "SysAdminMenu";
    }

    @PostMapping("/patientRegistrationsAdd")
    public String updateRegistration(Model model, @RequestParam("idReg") int idReg, @CookieValue("userId") String cookieId){
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
                Registration reg = new Registration();
                //Logger.getAnonymousLogger().info(reg.getID_Emp_Reg().getID_Employee().toString());
                Call<Registration> updateExec = api.updateRegPatient(Long.valueOf(idReg), Long.parseLong(cookieId));
                updateExec.execute();
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return "redirect:/PatientMenu";
    }

    @PostMapping("/patientRegistrationsDelete")
    public String deleteRegPatient (@RequestParam("idReg") int idReg){
        try {
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Registration reg = new Registration();
            //Logger.getAnonymousLogger().info(reg.getID_Emp_Reg().getID_Employee().toString());
            Call<Registration> updateExec = api.updateRegPatient(Long.valueOf(idReg), 0l);
            updateExec.execute();
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return "redirect:/RegistrationsList";
    }
}
