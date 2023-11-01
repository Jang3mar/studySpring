package com.example.medapi.controllers;

import com.example.medapi.DAO.AllDAO;
import com.example.medapi.Models.Employee;
import com.example.medapi.Models.Patient;
import com.example.medapi.Models.Position;
import com.example.medapi.Models.Position_Employee;
import com.example.medapi.Models.plugs.Position_Employee_Info;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class HomeController {

    AllDAO allDAO = new AllDAO();

    //"/getPosition"
    @GetMapping(value = "/getPosition")
    @ResponseBody
    public List<Position> returnPosition(){
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

    @GetMapping(value = "/getPositionEmployee")
    @ResponseBody
    public List<Position_Employee> returnPosEmp() {
        List<Position_Employee> positionEmployeeList = new ArrayList<>();
        ResultSet res = allDAO.selectToTable("Position_Employee", Position_Employee.class);
        try {
            while (res.next()) {
                Position_Employee posEmp = new Position_Employee();
                Position position = returnPosition(res.getLong(3));
                Employee employee = returnEmployee(res.getLong(2));
                posEmp = new Position_Employee(res.getLong(1), employee, position);
                positionEmployeeList.add(posEmp);
            }
        }
        catch (Exception e) {}
        return positionEmployeeList;
    }

    @GetMapping("/getPosition/{id}")
    @ResponseBody
    public Position returnPosition(@PathVariable("id") Long id){
        List<Position> positionList = returnPosition();
        return positionList.stream().filter(position -> position.getID_Position() == id).findAny().orElse(null);
    }

    @GetMapping("/getEmployee/{id}")
    @ResponseBody
    public Employee returnEmployee(@PathVariable("id") Long id){
        List<Employee> employeeList = returnEmployee();
        return employeeList.stream().filter(employee -> employee.getID_Employee() == id).findAny().orElse(null);
    }

    @GetMapping("/getPatient/{id}")
    @ResponseBody
    public Patient returnPatient(@PathVariable("id") Long id){
        List<Patient> patientList = returnPatient();
        return patientList.stream().filter(patient -> patient.getID_Patient() == id).findAny().orElse(null);
    }

    @GetMapping("/getLogIn")
    public Map<String, Object> returnLogIn(@RequestParam("login") String login, @RequestParam("password") String password){
        List<Patient> patientList = returnPatient();
        Logger.getAnonymousLogger().info(login);
        Logger.getAnonymousLogger().info(password);
        Map<String, Object> map = new HashMap<>();
        Patient pat = patientList.stream().filter(patient -> patient.getLogin_Patient().equals(login) && patient.getPassword_Patient().equals(password)).findAny().orElse(null);
        if (pat != null){
            map.put("type", "P");
            map.put("id", pat.getID_Patient());
        }
        List<Employee> employeeList = returnEmployee();
        Logger.getAnonymousLogger().info(employeeList.get(0).getSecond_Employee());
        Employee emp = employeeList.stream().filter(employee -> employee.getLogin_Employee().equals(login) && employee.getPassword_Employee().equals(password)).findAny().orElse(null);
        if(emp != null){
            List<Position_Employee> posEmp = returnPosEmp().stream().filter(emp1 -> emp1.getID_Emp_Pos().getID_Employee() == emp.getID_Employee()).toList();
            for (Position_Employee item: posEmp) {
                if(item.getID_Pos_Emp().getPosition_Name().equals("Админ")){
                    map.put("type", "A");
                    map.put("id", emp.getID_Employee());
                    return map;
                }
            }
            map.put("type", "E");
            map.put("id", emp.getID_Employee());
        }
        return map;
    }

    @PostMapping(value = "/addPosition")
    public Position addPosition(@RequestBody Position position){
        try{
            allDAO.addToTable("Position", position);
            return new Position();
        }
        catch (Exception e){return null;}
    }

    @PostMapping(value = "/registerPatient")
    public Patient registerPatient(@RequestBody Patient patient){
        try{
            allDAO.addToTable("Patient", patient);
            return new Patient();
        }
        catch (Exception e){return null;}
    }

    @PostMapping(value = "/addPositionEmp")
    public Position_Employee addPosEmp(@RequestBody Position_Employee posEmp){
        try{
            Logger.getLogger("Logas").info(posEmp.getID_Pos_Emp().getPosition_Name());

            allDAO.addToTable("Position_Employee", new Position_Employee_Info(0l, posEmp.getID_Emp_Pos().getID_Employee(),posEmp.getID_Pos_Emp().getID_Position()));
            return new Position_Employee();
        }
        catch (Exception e){return null;}
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

    @DeleteMapping("/deletePositionEmp/{id}")
    public Position_Employee deletePosEmp(@PathVariable("id") Long id){
        try{
            Position_Employee posEmp = new Position_Employee();
            posEmp.setID_Position_Employee(id);
            allDAO.deleteToTable("Position_Employee", posEmp);
            return new Position_Employee();
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

    @PostMapping("/updatePosition/{id}")
    public Position updatePosition(@PathVariable("id") Long id, @RequestBody Position position){
        try{
            allDAO.updateToTable("Position", position, position.getID_Position());
            return new Position();
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
}
