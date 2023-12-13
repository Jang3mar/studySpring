package com.example.medinstitution.models.views;

public class read_all_receptions {
    private Long id_reception;
    private Long id_registration;
    private Long id_diagnosis;
    private Long id_employee;
    private String date_reception;
    private String time_reception;
    private String status_reception;
    private String icd_code;
    private String name_diagnosis;
    private String des_symptoms;
    private String second_employee;
    private String first_employee;
    private String middle_employee;
    private String positions;

    public read_all_receptions(Long id_reception, Long id_registration, Long id_diagnosis, Long id_employee, String date_reception, String time_reception, String status_reception, String icd_code, String name_diagnosis, String des_symptoms, String second_employee, String first_employee, String middle_employee, String positions) {
        this.id_reception = id_reception;
        this.id_registration = id_registration;
        this.id_diagnosis = id_diagnosis;
        this.id_employee = id_employee;
        this.date_reception = date_reception;
        this.time_reception = time_reception;
        this.status_reception = status_reception;
        this.icd_code = icd_code;
        this.name_diagnosis = name_diagnosis;
        this.des_symptoms = des_symptoms;
        this.second_employee = second_employee;
        this.first_employee = first_employee;
        this.middle_employee = middle_employee;
        this.positions = positions;
    }

    public Long getId_reception() {
        return id_reception;
    }

    public void setId_reception(Long id_reception) {
        this.id_reception = id_reception;
    }

    public Long getId_registration() {
        return id_registration;
    }

    public void setId_registration(Long id_registration) {
        this.id_registration = id_registration;
    }

    public Long getId_diagnosis() {
        return id_diagnosis;
    }

    public void setId_diagnosis(Long id_diagnosis) {
        this.id_diagnosis = id_diagnosis;
    }

    public Long getId_employee() {
        return id_employee;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }

    public String getDate_reception() {
        return date_reception;
    }

    public void setDate_reception(String date_reception) {
        this.date_reception = date_reception;
    }

    public String getTime_reception() {
        return time_reception;
    }

    public void setTime_reception(String time_reception) {
        this.time_reception = time_reception;
    }

    public String getStatus_reception() {
        return status_reception;
    }

    public void setStatus_reception(String status_reception) {
        this.status_reception = status_reception;
    }

    public String getIcd_code() {
        return icd_code;
    }

    public void setIcd_code(String icd_code) {
        this.icd_code = icd_code;
    }

    public String getName_diagnosis() {
        return name_diagnosis;
    }

    public void setName_diagnosis(String name_diagnosis) {
        this.name_diagnosis = name_diagnosis;
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
}
