package com.example.medapi.Models.views;

public class read_all_registrations {

    private Long id_registration;
    private Long id_employee;
    private Long id_patient;
    private String date_reg;
    private String time_reg;
    private String des_symptoms;
    private String second_employee;
    private String first_employee;
    private String middle_employee;
    private String positions;
    private String departments;

    public read_all_registrations() {}

    public read_all_registrations(Long id_registration, Long id_employee, Long id_patient, String date_reg, String time_reg, String des_symptoms, String second_employee, String first_employee, String middle_employee, String positions, String departments) {
        this.id_registration = id_registration;
        this.id_employee = id_employee;
        this.id_patient = id_patient;
        this.date_reg = date_reg;
        this.time_reg = time_reg;
        this.des_symptoms = des_symptoms;
        this.second_employee = second_employee;
        this.first_employee = first_employee;
        this.middle_employee = middle_employee;
        this.positions = positions;
        this.departments = departments;
    }

    public Long getId_registration() {
        return id_registration;
    }

    public void setId_registration(Long id_registration) {
        this.id_registration = id_registration;
    }

    public Long getId_employee() {
        return id_employee;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }

    public String getDate_reg() {
        return date_reg;
    }

    public void setDate_reg(String date_reg) {
        this.date_reg = date_reg;
    }

    public String getTime_reg() {
        return time_reg;
    }

    public void setTime_reg(String time_reg) {
        this.time_reg = time_reg;
    }

    public String getDes_symptoms() {
        return des_symptoms;
    }

    public void setDes_symptoms(String des_symptoms) {
        this.des_symptoms = des_symptoms;
    }

    public String getSecond_employee() {
        return second_employee;
    }

    public void setSecond_employee(String second_employee) {
        this.second_employee = second_employee;
    }

    public String getFirst_employee() {
        return first_employee;
    }

    public void setFirst_employee(String first_employee) {
        this.first_employee = first_employee;
    }

    public String getMiddle_employee() {
        return middle_employee;
    }

    public void setMiddle_employee(String middle_employee) {
        this.middle_employee = middle_employee;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }
}
