package com.example.medapi.controllers;

import com.example.medapi.DAO.AllDAO;
import com.example.medapi.Models.*;
import com.example.medapi.Models.plugs.*;
import com.example.medapi.Models.views.read_all_receptions;
import com.example.medapi.Models.views.read_all_registrations;
import com.example.medapi.modifies.BackupBase;
import com.example.medapi.modifies.Crypto;
import com.mysql.cj.log.Log;
import org.apache.tomcat.util.bcel.Const;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class HomeController {

    AllDAO allDAO = new AllDAO();


    //-------------должность-----------------------
    //"/getPosition"
    @GetMapping(value = "/getPosition")
    @ResponseBody
    public List<Position> returnPosition() throws SQLException {
        List<Position> positionList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Position", Position.class);
        try {
            Position position = new Position();
            while (res.next()) {
                position = new Position(res.getLong(1), res.getString(2));
                positionList.add(position);
            }
        }
        catch (SQLException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return positionList;
    }

    @GetMapping("/getPosition/{id}")
    @ResponseBody
    public Position returnPosition(@PathVariable("id") Long id) throws SQLException {
        List<Position> positionList = returnPosition();
        return positionList.stream().filter(position -> position.getID_Position() == id).findAny().orElse(null);
    }

    @DeleteMapping("/deletePosition/{id}")
    public Position deletePosition(@PathVariable("id") Long id){
        try{
            Position position = new Position();
            position.setID_Position(id);
            allDAO.deleteToTable("Position", position);
            return new Position();
        }
        catch (Exception e){return null;}
    }

    @PostMapping(value = "/addPosition")
    public Position addPosition(@RequestBody Position position){
        try{
            allDAO.addToTable("Position", position);
            return new Position();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updatePosition/{id}")
    public Position updatePosition(@PathVariable("id") Long id, @RequestBody Position position){
        try{
            allDAO.updateToTable("Position", position, position.getID_Position());
            return new Position();
        }
        catch (Exception e){return null;}
    }

    //--------------------------------------------

    //-----------------отделение-------------------------

    @GetMapping(value = "/getDepartmentMed")
    @ResponseBody
    public List<DepartmentMed> returnDepartment(){
        List<DepartmentMed> departmentList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Department_Med", DepartmentMed.class);
        try {
            DepartmentMed departmentMed = new DepartmentMed();
            while (res.next()) {
                departmentMed = new DepartmentMed(res.getLong(1), res.getString(2));
                departmentList.add(departmentMed);
            }
        }
        catch (SQLException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return departmentList;
    }

    @GetMapping("/getDepartmentMed/{id}")
    @ResponseBody
    public DepartmentMed returnDepartment(@PathVariable("id") Long id){
        List<DepartmentMed> departmentList = returnDepartment();
        return departmentList.stream().filter(departmentMed -> departmentMed.getID_Dep_Med() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addDepartmentMed")
    public DepartmentMed addDepartment(@RequestBody DepartmentMed departmentMed){
        try{
            allDAO.addToTable("Department_Med", departmentMed);
            return new DepartmentMed();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateDepartmentMed/{id}")
    public DepartmentMed updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentMed departmentMed){
        try{
            allDAO.updateToTable("Department_Med", departmentMed, departmentMed.getID_Dep_Med());
            return new DepartmentMed();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteDepartmentMed/{id}")
    public DepartmentMed deleteDepartment(@PathVariable("id") Long id){
        try{
            DepartmentMed departmentMed = new DepartmentMed();
            departmentMed.setID_Dep_Med(id);
            allDAO.deleteToTable("Department_Med", departmentMed);
            return new DepartmentMed();
        }
        catch (Exception e){return null;}
    }

    //--------------------------------------------

    //---------------диагнозы-----------------------

    @GetMapping(value = "/getDiagnosis")
    @ResponseBody
    public List<Diagnosis> returnDiagnosis(){
        List<Diagnosis> diagnosisList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Diagnosis", Diagnosis.class);
        try {
            Diagnosis diagnosis = new Diagnosis();
            while (res.next()) {
                diagnosis = new Diagnosis(res.getLong(1), res.getString(2), res.getString(3));
                diagnosisList.add(diagnosis);
            }
        }
        catch (SQLException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return diagnosisList;
    }

    @GetMapping("/getDiagnosis/{id}")
    @ResponseBody
    public Diagnosis returnDiagnosis(@PathVariable("id") Long id){
        List<Diagnosis> diagnosisList = returnDiagnosis();
        return diagnosisList.stream().filter(diagnosis -> diagnosis.getID_Diagnosis() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addDiagnosis")
    public Diagnosis addDiagnosis(@RequestBody Diagnosis diagnosis){
        try{
            allDAO.addToTable("Diagnosis", diagnosis);
            return new Diagnosis();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateDiagnosis/{id}")
    public Diagnosis updateDiagnosis(@PathVariable("id") Long id, @RequestBody Diagnosis diagnosis){
        try{
            allDAO.updateToTable("Diagnosis", diagnosis, diagnosis.getID_Diagnosis());
            return new Diagnosis();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteDiagnosis/{id}")
    public Diagnosis deleteDiagnosis(@PathVariable("id") Long id){
        try{
            Diagnosis diagnosis = new Diagnosis();
            diagnosis.setID_Diagnosis(id);
            allDAO.deleteToTable("Diagnosis", diagnosis);
            return new Diagnosis();
        }
        catch (Exception e){return null;}
    }

    //--------------------------------------------

    //----------------сотрудники------------------

    @GetMapping(value = "/getEmployee")
    @ResponseBody
    public List<Employee> returnEmployee(){
        List<Employee> employeeList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Employee", Employee.class);
        try {
            Employee employee = new Employee();
            while (res.next()) {
                employee = new Employee(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
                employeeList.add(employee);
            }
        }
        catch (SQLException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return employeeList;
    }

    @GetMapping("/getEmployee/{id}")
    @ResponseBody
    public Employee returnEmployee(@PathVariable("id") Long id){
        List<Employee> employeeList = returnEmployee();
        Logger.getAnonymousLogger().info("Here: " + employeeList.size());
        return employeeList.stream().filter(employee -> employee.getID_Employee() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        try{
            allDAO.addToTable("Employee", employee);
            return new Employee();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        try{
            allDAO.updateToTable("Employee", employee, employee.getID_Employee());
            return new Employee();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public Employee deleteEmployee(@PathVariable("id") Long id){
        try{
            Employee employee = new Employee();
            employee.setID_Employee(id);
            allDAO.deleteToTable("Employee", employee);
            return new Employee();
        }
        catch (Exception e){return null;}
    }

    //--------------------------------------------

    //----------------пациенты--------------------

    @GetMapping(value = "/getPatient")
    @ResponseBody
    public List<Patient> returnPatient(){
        List<Patient> patientList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Patient", Patient.class);
        try{
            Patient patient = new Patient();
            while (res.next()){
                patient = new Patient(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
                patientList.add(patient);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return patientList;
    }

    @GetMapping("/getPatient/{id}")
    @ResponseBody
    public Patient returnPatient(@PathVariable("id") Long id){
        try {
            List<Patient> patientList = returnPatient();
            Patient pat = patientList.stream().filter(patient -> patient.getID_Patient() ==
                    id).findAny().orElse(null);
            //pat.setLogin_Patient(reverseHashString(pat.getLogin_Patient()));
            //pat.setPassword_Patient(reverseHashString(pat.getPassword_Patient()));

            //для получения информации о пользователе расшифровываем логин и перезаписываем его
            pat.setLogin_Patient(Crypto.decrypt(pat.getLogin_Patient()));
            return pat;
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return null;
    }

    @PostMapping(value = "/Ы")
    public Patient registerPatient(@RequestBody Patient patient){
        try{
            //patient.setLogin_Patient(hashString(patient.getLogin_Patient()));
            //patient.setPassword_Patient(hashString(patient.getPassword_Patient()));
            allDAO.addToTable("Patient", patient);
            return new Patient();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updatePatient/{id}")
    public Patient updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient){
        try{
            allDAO.updateToTable("Patient", patient, patient.getID_Patient());
            return new Patient();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deletePatient/{id}")
    public Patient deletePatient(@PathVariable("id") Long id){
        try{
            Patient patient = new Patient();
            patient.setID_Patient(id);
            allDAO.deleteToTable("Patient", patient);
            return new Patient();
        }
        catch (Exception e){return null;}
    }

    //--------------------------------------------

    //----------------образование-----------------

    @GetMapping(value = "/getEducation")
    @ResponseBody
    public List<Education> returnEducation(){
        List<Education> educationList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Education", Education.class);
        try{
            Education education = new Education();
            while (res.next()){
                education = new Education(res.getLong(1), res.getString(2), res.getString(3), res.getString(4));
                educationList.add(education);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return educationList;
    }

    @GetMapping("/getEducation/{id}")
    @ResponseBody
    public Education returnEducation(@PathVariable("id") Long id){
        List<Education> educationList = returnEducation();
        return educationList.stream().filter(education -> education.getID_Education() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addEducation")
    public Education addEducation(@RequestBody Education education){
        try{
            allDAO.addToTable("Education", education);
            return new Education();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateEducation/{id}")
    public Education updateEducation(@PathVariable("id") Long id, @RequestBody Education education){
        try{
            allDAO.updateToTable("Education", education, education.getID_Education());
            return new Education();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteEducation/{id}")
    public Education deleteEducation(@PathVariable("id") Long id){
        try{
            Education education = new Education();
            education.setID_Education(id);
            allDAO.deleteToTable("Education", education);
            return new Education();
        }
        catch (Exception e){return null;}
    }

    //-------------------------------------------

    //---------------документы-------------------

    @GetMapping(value = "/getDocument/{id}")
    @ResponseBody
    public Document getDocument(@PathVariable("id") Long id)  {
        List<Document> documentList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Document", Document.class);
        try {
            if(res != null)
                while (res.next()) {
                    Document doc = new Document(res.getLong(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                            res.getString(6),
                            res.getString(7),
                            returnPatient(res.getLong(8)));
                    documentList.add(doc);
                }
        }
        catch (Exception e) {}
        return documentList.stream().filter(dc -> dc.getID_Patient().getID_Patient() == id).findAny().orElse(new Document());
    }

    @PostMapping("/addDocument")
    public Document addDocument(@RequestBody Document document){
        Logger.getAnonymousLogger().info(document.getDate_Issue());
        Document doc = getDocument(document.getID_Patient().getID_Patient());
        if(doc.getID_Document() == null)
            allDAO.addToTable("Document", new Document_Info(document));
        else allDAO.updateToTable("Document",new Document_Info(document), doc.getID_Document());
        return new Document();
    }

    @GetMapping(value = "/getDocument")
    @ResponseBody
    public List<Document> returnDocument(){
        List<Document> documentList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Document", Document.class);
        try{
            Document document = new Document();
            while (res.next()){
                Patient patient = returnPatient(res.getLong(8));
                document = new Document(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),patient);
                documentList.add(document);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return documentList;
    }

    //------------------------------------------

    //--------образование сотрудника------------

    @GetMapping(value = "/getEducationEmployee")
    @ResponseBody
    public List<Education_Employee> returnEduEmployee(){
        List<Education_Employee> eduEmployeeLis = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Education_Employee", Education_Employee.class);
        try{
            Education_Employee educationEmployee = new Education_Employee();
            while (res.next()){
                Education education = returnEducation(res.getLong(3));
                Employee employee = returnEmployee(res.getLong(2));
                educationEmployee = new Education_Employee(res.getLong(1), employee, education);
                eduEmployeeLis.add(educationEmployee);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return eduEmployeeLis;
    }

    @GetMapping(value = "/getEducationEmployee/{id}")
    @ResponseBody
    public Education_Employee returnEduEmployeeId(@PathVariable("id") Long id){
        List<Education_Employee> eduEmployeeLis = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Education_Employee", Education_Employee.class);
        try{
            Education_Employee educationEmployee = new Education_Employee();
            while (res.next()){
                Education education = returnEducation(res.getLong(3));
                Employee employee = returnEmployee(res.getLong(2));
                educationEmployee = new Education_Employee(res.getLong(1), employee, education);
                eduEmployeeLis.add(educationEmployee);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return eduEmployeeLis.stream().filter(educationEmployee -> educationEmployee.getID_Education_Employee() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addEducationEmployee")
    public Education_Employee addEduEmp(@RequestBody Education_Employee educationEmployee){
        try{
            //Logger.getLogger("Logas").info(posEmp.getID_Position().getPosition_Name());

            allDAO.addToTable("Education_Employee", new Education_Employee_Info(0l, educationEmployee.getID_Emp_Edu().getID_Employee(),educationEmployee.getID_Edu_Emp().getID_Education()));
            return new Education_Employee();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateEducationEmployee/{id}")
    public Education_Employee updateEduEmp(@PathVariable("id") Long id, @RequestBody Education_Employee educationEmployee){
        try{
            Education_Employee_Info educationEmployeeInfo = new Education_Employee_Info(educationEmployee.getID_Education_Employee(), educationEmployee.getID_Emp_Edu().getID_Employee(), educationEmployee.getID_Edu_Emp().getID_Education());
            allDAO.updateToTable("Education_Employee", educationEmployeeInfo, educationEmployee.getID_Education_Employee());
            return new Education_Employee();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteEduEmp/{id}")
    public Education_Employee deleteEduEmp(@PathVariable("id") Long id){
        try{
            Education_Employee eduEmp = new Education_Employee();
            eduEmp.setID_Education_Employee(id);
            allDAO.deleteToTable("Education_Employee", eduEmp);
            return new Education_Employee();
        }
        catch (Exception e){return null;}
    }

    //------------------------------------------

    //------------отделение сотрудника-----------

    @GetMapping(value = "/getEmployeeDepMed")
    @ResponseBody
    public List<Employee_Dep_Med> returnEmployeeDepMed(){
        List<Employee_Dep_Med> empDepMedList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Employee_Dep_Med", Employee_Dep_Med.class);
        try{
            Employee_Dep_Med employeeDepMed = new Employee_Dep_Med();
            while (res.next()){
                DepartmentMed departmentMed = returnDepartment(res.getLong(3));
                Employee employee = returnEmployee(res.getLong(2));
                employeeDepMed = new Employee_Dep_Med(res.getLong(1), employee, departmentMed);
                empDepMedList.add(employeeDepMed);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return empDepMedList;
    }

    @GetMapping(value = "/getEmployeeDepMed/{id}")
    @ResponseBody
    public Employee_Dep_Med returnEmployeeDepMedId(@PathVariable("id") Long id){
        List<Employee_Dep_Med> empDepMedList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Employee_Dep_Med", Employee_Dep_Med.class);
        try{
            Employee_Dep_Med empDepMed = new Employee_Dep_Med();
            while (res.next()){
                DepartmentMed departmentMed = returnDepartment(res.getLong(3));
                Employee employee = returnEmployee(res.getLong(2));
                empDepMed = new Employee_Dep_Med(res.getLong(1), employee, departmentMed);
                empDepMedList.add(empDepMed);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return empDepMedList.stream().filter(employeeDepMed -> employeeDepMed.getID_Employee_Dep_Med() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addEmployeeDepMed")
    public Employee_Dep_Med addEmpDepMed(@RequestBody Employee_Dep_Med employeeDepMed){
        try{
            //Logger.getLogger("Logas").info(posEmp.getID_Position().getPosition_Name());

            allDAO.addToTable("Employee_Dep_Med", new Employee_Dep_Med_Info(0l, employeeDepMed.getID_Emp_Dep().getID_Employee(),employeeDepMed.getID_Dep_Med().getID_Dep_Med()));
            return new Employee_Dep_Med();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateEmployeeDepMed/{id}")
    public Employee_Dep_Med updateEmpDepMed(@PathVariable("id") Long id, @RequestBody Employee_Dep_Med employeeDepMed){
        try{
            Employee_Dep_Med_Info educationEmployeeInfo = new Employee_Dep_Med_Info(employeeDepMed.getID_Employee_Dep_Med(), employeeDepMed.getID_Emp_Dep().getID_Employee(), employeeDepMed.getID_Dep_Med().getID_Dep_Med());
            allDAO.updateToTable("Employee_Dep_Med", educationEmployeeInfo, employeeDepMed.getID_Employee_Dep_Med());
            return new Employee_Dep_Med();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteEmployeeDepMed/{id}")
    public Employee_Dep_Med deleteEmpDepMed(@PathVariable("id") Long id){
        try{
            Employee_Dep_Med empDepMed = new Employee_Dep_Med();
            empDepMed.setID_Employee_Dep_Med(id);
            allDAO.deleteToTable("Employee_Dep_Med", empDepMed);
            return new Employee_Dep_Med();
        }
        catch (Exception e){return null;}
    }

//    @GetMapping("/getEmployeeByDepartment")
//    public List<Employee>

    //-------------------------------------------

    //------------должность сотрудника-----------

    @GetMapping(value = "/getPositionEmployee")
    @ResponseBody
    public List<Position_Employee> returnPosEmployee(){
        List<Position_Employee> posEmployeeLis = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Position_Employee", Position_Employee.class);
        try{
            Position_Employee positionEmployee = new Position_Employee();
            while (res.next()){
                Position position = returnPosition(res.getLong(3));
                Employee employee = returnEmployee(res.getLong(2));
                positionEmployee = new Position_Employee(res.getLong(1), employee, position);
                posEmployeeLis.add(positionEmployee);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return posEmployeeLis;
    }

    @GetMapping(value = "/getPositionEmployee/{id}")
    @ResponseBody
    public Position_Employee returnPosEmployeeId(@PathVariable("id") Long id){
        List<Position_Employee> posEmployeeList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Position_Employee", Position_Employee.class);
        try{
            Position_Employee positionEmployee = new Position_Employee();
            while (res.next()){
                Position position = returnPosition(res.getLong(3));
                Employee employee = returnEmployee(res.getLong(2));
                positionEmployee = new Position_Employee(res.getLong(1), employee, position);
                posEmployeeList.add(positionEmployee);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return posEmployeeList.stream().filter(positionEmployee -> positionEmployee.getID_Position_Employee() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addPositionEmployee")
    public Position_Employee addEduEmp(@RequestBody Position_Employee positionEmployee){
        try{
            //Logger.getLogger("Logas").info(posEmp.getID_Position().getPosition_Name());

            allDAO.addToTable("Position_Employee", new Position_Employee_Info(0l, positionEmployee.getID_Employee().getID_Employee(),positionEmployee.getID_Position().getID_Position()));
            return new Position_Employee();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updatePositionEmployee/{id}")
    public Position_Employee updatePosEmp(@PathVariable("id") Long id, @RequestBody Position_Employee positionEmployee){
        try{
            Position_Employee_Info positionEmployeeInfo = new Position_Employee_Info(positionEmployee.getID_Position_Employee(), positionEmployee.getID_Employee().getID_Employee(), positionEmployee.getID_Position().getID_Position());
            allDAO.updateToTable("Position_Employee", positionEmployeeInfo, positionEmployeeInfo.getID_Position_Employee());
            return new Position_Employee();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deletePosEmp/{id}")
    public Position_Employee deletePosEmp(@PathVariable("id") Long id){
        try{
            Position_Employee posEmp = new Position_Employee();
            posEmp.setID_Position_Employee(id);
            allDAO.deleteToTable("Position_Employee", posEmp);
            return new Position_Employee();
        }
        catch (Exception e){return null;}
    }

    //-------------------------------------------

    //-----------------справка-------------------

    @GetMapping(value = "/getMedReference")
    @ResponseBody
    public List<Med_Reference> returnMedRef(){
        List<Med_Reference> medRefList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Med_Reference", Med_Reference.class);
        try {
            Med_Reference medRef = new Med_Reference();
            while (res.next()) {
                // Reception reception = returnReception(res.getLong(4));
                //medRef = new Med_Reference(res.getLong(1), res.getString(2), res.getString(3), reception);
                medRefList.add(medRef);
            }
        }
        catch (SQLException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return medRefList;
    }

    @GetMapping(value = "/getMedReference/{id}")
    @ResponseBody
    public Med_Reference returnMedRefId(@PathVariable("id") Long id){
        List<Med_Reference> medRefList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Med_Reference", Med_Reference.class);
        try{
            Med_Reference medReference = new Med_Reference();
            while (res.next()){
                //Reception reception = returnReception(res.getLong(5));
                //medReference = new Med_Reference(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), reception);
                medRefList.add(medReference);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return medRefList.stream().filter(medReference -> medReference.getID_Med_Reference() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addMedReference")
    public Med_Reference addMedRef(@RequestBody Med_Reference medReference){
        try{
            allDAO.addToTable("Med_Reference", medReference);
            return new Med_Reference();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateMedReference/{id}")
    public Med_Reference updateMedReference(@PathVariable("id") Long id, @RequestBody Med_Reference medReference){
        try{
            allDAO.updateToTable("Med_Reference", medReference, medReference.getID_Med_Reference());
            return new Med_Reference();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteMedReference/{id}")
    public Med_Reference deleteMedReference(@PathVariable("id") Long id){
        try{
            Med_Reference medReference = new Med_Reference();
            medReference.setID_Med_Reference(id);
            allDAO.deleteToTable("Med_Reference", medReference);
            return new Med_Reference();
        }
        catch (Exception e){return null;}
    }

    //-------------------------------------------

    //------------справка мед карты--------------

    @GetMapping(value = "/getPatientMedCard")
    @ResponseBody
    public List<Patient_Med_Card> returnPatMedCard(){
        List<Patient_Med_Card> patientMedCardList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Patient_Med_Card", Patient_Med_Card.class);
        try{
            Patient_Med_Card patientMedCard = new Patient_Med_Card();
            while (res.next()){
                Medical_Card medicalCard = returnMedCardId(res.getLong(2));
                Med_Reference medReference = returnMedRefId(res.getLong(3));
                patientMedCard = new Patient_Med_Card(res.getLong(1), medicalCard, medReference);
                patientMedCardList.add(patientMedCard);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return patientMedCardList;
    }

    @GetMapping(value = "/getPatientMedCard/{id}")
    @ResponseBody
    public Patient_Med_Card returnPatientMedCardId(@PathVariable("id") Long id){
        List<Patient_Med_Card> patientMedCardList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Patient_Med_Card", Patient_Med_Card.class);
        try{
            Patient_Med_Card patientMedCard = new Patient_Med_Card();
            while (res.next()){
                Medical_Card medicalCard = returnMedCardId(res.getLong(2));
                Med_Reference medReference = returnMedRefId(res.getLong(3));
                patientMedCard = new Patient_Med_Card(res.getLong(1), medicalCard, medReference);
                patientMedCardList.add(patientMedCard);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return patientMedCardList.stream().filter(patientMedCard -> patientMedCard.getID_Pat_Med_Card() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addPatientMedCard")
    public Patient_Med_Card addPatientMedCard(@RequestBody Patient_Med_Card patientMedCard){
        try{
            //Logger.getLogger("Logas").info(posEmp.getID_Position().getPosition_Name());

            allDAO.addToTable("Patient_Med_Card", new Patient_Med_Card_Info(0l, patientMedCard.getID_Med_Card_Ref().getID_Med_Card(),patientMedCard.getID_Ref_Med_Card().getID_Med_Reference()));
            return new Patient_Med_Card();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updatePatientMedCard/{id}")
    public Patient_Med_Card updatePatientMedCard(@PathVariable("id") Long id, @RequestBody Patient_Med_Card patientMedCard){
        try{
            Patient_Med_Card_Info patientMedCardInfo = new Patient_Med_Card_Info(patientMedCard.getID_Pat_Med_Card(), patientMedCard.getID_Med_Card_Ref().getID_Med_Card(), patientMedCard.getID_Ref_Med_Card().getID_Med_Reference());
            allDAO.updateToTable("Patient_Med_Card", patientMedCardInfo, patientMedCard.getID_Pat_Med_Card());
            return new Patient_Med_Card();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deletePatientMedCard/{id}")
    public Patient_Med_Card deletePatientMedCard(@PathVariable("id") Long id){
        try{
            Patient_Med_Card patientMedCard = new Patient_Med_Card();
            patientMedCard.setID_Pat_Med_Card(id);
            allDAO.deleteToTable("Patient_Med_Card", patientMedCard);
            return new Patient_Med_Card();
        }
        catch (Exception e){return null;}
    }

    //-------------------------------------------

    //------------медицинская карта--------------

    @GetMapping(value = "/getMedicalCard")
    @ResponseBody
    public List<Medical_Card> returnMedCard(){
        List<Medical_Card> medicalCardList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Medical_Card", Medical_Card.class);
        try {
            Medical_Card medCard = new Medical_Card();
            while (res.next()) {
                Patient patient = returnPatient(res.getLong(3));
                medCard = new Medical_Card(res.getLong(1), res.getString(2), patient);
                medicalCardList.add(medCard);
            }
        }
        catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return medicalCardList;
    }

    @GetMapping(value = "/getMedicalCard/{id}")
    @ResponseBody
    public Medical_Card returnMedCardId(@PathVariable("id") Long id){
        List<Medical_Card> medicalCardList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Medical_Card", Medical_Card.class);
        try{
            Medical_Card medicalCard = new Medical_Card();
            while (res.next()){
                Patient patient = returnPatient(res.getLong(3));
                medicalCard = new Medical_Card(res.getLong(1), res.getString(2), patient);
                medicalCardList.add(medicalCard);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return medicalCardList.stream().filter(medicalCard -> medicalCard.getID_Med_Card() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addMedicalCard")
    public Medical_Card addMedCard(@RequestBody Medical_Card medicalCard){
        try{
            allDAO.addToTable("Medical_Card", medicalCard);
            return new Medical_Card();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateMedicalCard/{id}")
    public Medical_Card updateMedCard(@PathVariable("id") Long id, @RequestBody Medical_Card medicalCard){
        try{
            allDAO.updateToTable("Medical_Card", medicalCard, medicalCard.getID_Med_Card());
            return new Medical_Card();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteMedicalCard/{id}")
    public Medical_Card deleteMedCard(@PathVariable("id") Long id){
        try{
            Medical_Card medicalCard = new Medical_Card();
            medicalCard.setID_Med_Card(id);
            allDAO.deleteToTable("Medical_Card", medicalCard);
            return new Medical_Card();
        }
        catch (Exception e){return null;}
    }

    //-------------------------------------------

    //-----------------прием----------------------

    @GetMapping(value = "/getReception")
    @ResponseBody
    public List<Reception> returnReception(){
        List<Reception> receptionList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Reception", Reception.class);
        try{
            Reception reception = new Reception();
            while (res.next()){
              //  Registration registration = returnRegistration(res.getLong(4));
                //Diagnosis diagnosis = returnDiagnosis(res.getLong(5));
                //reception = new Reception(res.getLong(1), res.getString(2), res.getString(3), res.getLong(4), res.getLong(5));
                receptionList.add(reception);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return receptionList;
    }

    @GetMapping(value = "/getReception/{id}")
    @ResponseBody
    public Reception returnReceptionId(@PathVariable("id") Long id){
        List<Reception> receptionList = returnReception();
        return receptionList.stream().filter(reception -> reception.getID_Reception() == id).findAny().orElse(null);
    }

    @PostMapping(value = "/addReception")
    public Reception addReception(@RequestBody Reception reception){
        try{
            //Logger.getLogger("Logas").info(posEmp.getID_Position().getPosition_Name());

           // allDAO.addToTable("Reception", new Reception(0l, reception.getID_Reg_Rec().getID_Registration(),reception.getID_Dig_Rec().getID_Diagnosis()));
            return new Reception();
        }
        catch (Exception e){return null;}
    }

    @PostMapping("/updateReception/{id}")
    public Reception updateReception(@PathVariable("id") Long id, @RequestBody Reception reception){
        try{
            Reception_Info receptionInfo = new Reception_Info();
            allDAO.updateToTable("Reception", receptionInfo, receptionInfo.getID_Reception());
            return new Reception();
        }
        catch (Exception e){return null;}
    }

    @DeleteMapping("/deleteReception/{id}")
    public Reception deleteReception(@PathVariable("id") Long id){
        try{
            Reception reception = new Reception();
            reception.setID_Reception(id);
            allDAO.deleteToTable("Reception", reception);
            return new Reception();
        }
        catch (Exception e){return null;}
    }

    //-------------------------------------------

    //----------------запись----------------------



    //-------------------------------------------




    @GetMapping(value = "/getFreeRegistration")
    @ResponseBody
    public List<Registration> getFreeRegistration(){
        List<Registration> registrationList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Registration", Registration.class);
        List<Employee> employees = returnEmployee();
        try {
            Registration registration = new Registration();
            if(res != null)
                while (res.next()) {
                    Logger.getLogger("LONGER").info(res.getLong(5)+"");
                    registration = new Registration(res.getLong(1),
                            res.getString(2),res.getString(3),
                            res.getString(4),
                            employees.stream().filter(emp -> {
                                try {
                                    return emp.getID_Employee() == res.getLong(5);
                                } catch (SQLException e) {
                                    return false;
                                }
                            }).findFirst().orElse(null),
                            new Patient());
                    if(res.getLong(6) == 0) registrationList.add(registration);
                }
        }
        catch (SQLException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return registrationList;
    }

    @GetMapping(value = "/getRegistration")
    @ResponseBody
    public List<Registration> getRegistration(){
        List<Registration> registrationList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Registration", Registration.class);
        try {
            Registration registration = new Registration();
            if(res != null)
                while (res.next()) {
                    Patient pt = returnPatient(res.getLong(6));
                    Employee emp = returnEmployee(res.getLong(5));
                    Logger.getAnonymousLogger().info(res.getLong(5) + "");
                    registration = new Registration(res.getLong(1), res.getString(2),res.getString(3), res.getString(4), emp,pt);
                    registrationList.add(registration);
                }
        }
        catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return registrationList;
    }

    @GetMapping(value = "/getRegistration/{id}")
    @ResponseBody
    public Registration returnRegistrationId(@PathVariable("id") Long id){
        List<Registration> registrationList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Registration", Registration.class);
        try{
            Registration registration = new Registration();
            while (res.next()){
                Patient patient = returnPatient(res.getLong(6));
                Employee employee = returnEmployee(res.getLong(5));
//                Logger.getAnonymousLogger().info(id + "");
                Logger.getAnonymousLogger().info(employee.getID_Employee() + " AAAAAAAAAAA");
                registration = new Registration(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), employee, patient);
                registrationList.add(registration);
            }
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        Logger.getAnonymousLogger().info(registrationList.size() + "");
        Logger.getAnonymousLogger().info(registrationList.stream().filter(registration -> registration.getID_Registration() == id).findAny().orElse(null).getID_Registration() + " AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return registrationList.stream().filter(registration -> registration.getID_Registration() == id).findAny().orElse(null);
    }

    @PostMapping("/updateRegPatient/{id}")
    public Registration updateRegistration(@PathVariable("id") Long id, @RequestParam("idUser") Long idUser){
        try{
            if(idUser == 0) {
                Logger.getAnonymousLogger().info("This");
                Registration regs = returnRegistrationId(id);
                Registration_Info registrationInfo = new Registration_Info(regs.getID_Registration(), regs.getDate_Reg(), regs.getTime_Reg(), "", regs.getID_Employee().getID_Employee(), null);
                allDAO.updateToTable("Registration", registrationInfo, registrationInfo.getID_Registration());
            }
            else{
                Registration regs = returnRegistrationId(id);
                Registration_Info registrationInfo = new Registration_Info(regs.getID_Registration(), regs.getDate_Reg(), regs.getTime_Reg(), regs.getDes_Symptoms(), regs.getID_Employee().getID_Employee(), idUser);
                allDAO.updateToTable("Registration", registrationInfo, registrationInfo.getID_Registration());
            }
            return new Registration();
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
        return null;
    }

    @PostMapping("/updateRegistrations/{id}")
    public Registration updateRegistration(@PathVariable("id") Long id, @RequestBody Registration registration){
        try{
            Registration regs = returnRegistrationId(id);
            regs.setDes_Symptoms(registration.getDes_Symptoms());
            Logger.getAnonymousLogger().info("Here");
            Registration_Info registrationInfo = new Registration_Info(regs.getID_Registration(), regs.getDate_Reg(), regs.getTime_Reg(), regs.getDes_Symptoms(), regs.getID_Employee().getID_Employee(), regs.getID_Patient().getID_Patient());
            allDAO.updateToTable("Registration", registrationInfo, registrationInfo.getID_Registration());
            return new Registration();
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
        return null;
    }


    @GetMapping("/getAllRegistrationsView")
    public List<read_all_registrations> readAllRegistrations(){
        List<read_all_registrations> readRegs = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("read_all_registrations", read_all_registrations.class);
        try {
            read_all_registrations read_all_registrations = new read_all_registrations();
            if(res != null)
                while (res.next()) {
                    read_all_registrations = new read_all_registrations(res.getLong(1), res.getLong(2), res.getLong(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11));
                    readRegs.add(read_all_registrations);
                }
        }
        catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return readRegs;
    }

    @GetMapping("/getAllReceptionView")
    public List<read_all_receptions> readAllReceptions(){
        List<read_all_receptions> readRec = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("read_all_receptions", read_all_receptions.class);
        try {
            read_all_receptions readAllReceptions = new read_all_receptions();
            if(res != null)
                while (res.next()) {
                    readAllReceptions = new read_all_receptions(res.getLong(1), res.getLong(2), res.getLong(3), res.getLong(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14));
                    readRec.add(readAllReceptions);
                }
        }
        catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return readRec;
    }

    @GetMapping("/getLogIn")
    public Map<String, Object> returnLogIn(@RequestParam("login") String login,
                                           @RequestParam("password") String password) {

        //String newLogin = hashString(login);
        //String newPassword = hashString(password);
        try {

            List<Patient> patientList = returnPatient();
            Logger.getAnonymousLogger().info(login);
            Logger.getAnonymousLogger().info(password);
            Map<String, Object> map = new HashMap<>();
            Patient patientNew = patientList.stream().filter(patient -> {
                try {
                    return Crypto.decrypt(patient.getLogin_Patient()).equals(login) &&
                            Crypto.decrypt(patient.getPassword_Patient()).equals(password);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).findAny().orElse(null);
            if (patientNew != null) {
                map.put("type", "P");
                map.put("id", patientNew.getID_Patient());
            }
            List<Employee> employeeList = returnEmployee();
            //Logger.getAnonymousLogger().info(employeeList.get(0).getSecond_Employee());
            Employee emp = employeeList.stream().filter(employee -> {
                try {
                    return Crypto.decrypt(employee.getLogin_Employee()).equals(login) &&
                            Crypto.decrypt(employee.getPassword_Employee()).equals(password);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).findAny().orElse(null);
            if (emp != null) {
                List<Position_Employee> posEmp = returnPosEmployee().stream().filter(emp1 -> emp1.getID_Employee().getID_Employee() == emp.getID_Employee()).toList();
                for (Position_Employee item : posEmp) {
                    if (item.getID_Position().getPosition_Name().equals("Админ")) {
                        map.put("type", "A");
                        map.put("id", emp.getID_Employee());
                        return map;
                    } else if (item.getID_Position().getPosition_Name().equals("Системный администратор")) {
                        map.put("type", "S");
                        map.put("id", emp.getID_Employee());
                        return map;
                    }
                }
                map.put("type", "E");
                map.put("id", emp.getID_Employee());
            }
            String enteranceString = "";
            if (map.containsKey("type")) {
                enteranceString = map.get("type").equals("P") ? "Вход пациента с id - " : "Вход сотрудника с id - ";
                enteranceString += map.get("id");
                allDAO.noLogAdd("Loggers", new Loggers(0l,
                        enteranceString,
                        LocalDateTime.now().toLocalDate().toString())
                );
            }
            return map;
        }
        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
        return null;
    }

//    @GetMapping("/AdminPanel/addBackup")
//    public ResponseEntity<String> getBackup(){
//        try {
//            BackupBase backupBase = new BackupBase();
//            backupBase.createBackup("3306", "8081", "medInst", "root", "", "/path/to/backup.sql");
//            return ResponseEntity.ok("Backup initiated successfully");
//        }
//        catch (Exception e) {Logger.getAnonymousLogger().info(e.getMessage());}
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error initiating backup");
//    }

    @GetMapping("/SysAdminMenu")
    public List<Loggers> returnLoggers(){
        List<Loggers> loggersList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Loggers", Loggers.class);
        try {
            Loggers log = new Loggers();
            while (res.next()) {
                log = new Loggers(res.getLong(1),
                        res.getString(2),
                        res.getString(3));
                loggersList.add(log);
            }
        }
        catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return loggersList;
    }


}
