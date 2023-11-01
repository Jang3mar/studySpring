package com.example.medinstitution.controllers;

import com.example.medinstitution.models.*;
import com.example.medinstitution.models.plugs.EmpPositionInfo;
import com.example.medinstitution.utilities.APIInterface;
import com.example.medinstitution.utilities.RequestBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getAutho(Model model, HttpServletRequest httpRequest) {
        Cookie cok = Arrays.stream(httpRequest.getCookies()).filter(cookie -> cookie.getName().equals("userId")).findAny().orElse(null);
        return "AuthorisationWin";
    }

    @GetMapping("/AuthorisationWin/RegistrationWin")
    public String getRegistration() {
        return "RegistrationWin";
    }

    @GetMapping("/PatientMenu")
    public String getPatientMenu(Model model){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            List<Registration> PE = api.getRegistrarions().execute().body();
            List<EmpPositionInfo> epInfo = new ArrayList<>();
            for (Registration reg: PE) {
                epInfo.add(new EmpPositionInfo(reg.getID_Emp_Reg()));
            }
            model.addAttribute("regs", epInfo);
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());};
        return "PatientMenu";
    }

    @GetMapping("/PrivateRoom")
    public String getPrivateRoom(){
        return "PrivateRoom";
    }

    @GetMapping("/EmployeeMenu")
    public String getEmployeeMenu(Model model){
        return "EmployeeMenu";
    }

    @GetMapping("/AdminPanel")
    public String getAdmin() {
        return "AdminPanel";
    }

    @GetMapping("/AdminPanel/modelsWin/DepartamentWin")
    public String getDepartment() {
        return "modelsWin/DepartamentWin";
    }

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
    public String getEmployee() {
        return "modelsWin/EmployeeWin";
    }

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
                               @RequestParam(name = "birthdayPatient") String birthdayPatient){
        try{
            APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
            Call<Patient> newPatient = api.registerPatient(new Patient(0l, secondName, firstName, middleName, loginPatient, passwordPatient, birthdayPatient));
            newPatient.execute();
            Call<List<Patient>> listPatient = api.getListPatient();
            Response<List<Patient>> res = listPatient.execute();
            model.addAttribute("patientList", res.body());
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
}
