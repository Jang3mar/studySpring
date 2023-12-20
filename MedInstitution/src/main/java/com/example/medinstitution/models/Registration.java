package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Registration {

    @SerializedName(value = "id_Registration")
    private Long ID_Registration;

    @SerializedName(value = "date_Reg")
    private String Date_Reg;

    @SerializedName(value = "time_Reg")
    private String Time_Reg;

    @SerializedName(value = "des_Symptoms")
    private String Des_Symptoms;

    @SerializedName(value = "id_Employee")
    private Employee ID_Employee;

    @SerializedName(value = "id_Patient")
    private Patient ID_Patient;

    public Registration() {}

    public Registration(Long ID_Registration, String date_Reg, String time_Reg, String DesSymptoms,  Employee ID_Emp_Reg, Patient ID_Pat_Reg) {
        this.ID_Registration = ID_Registration;
        Date_Reg = date_Reg;
        Time_Reg = time_Reg;
        Des_Symptoms = DesSymptoms;
        this.ID_Employee = ID_Emp_Reg;
        this.ID_Patient = ID_Pat_Reg;
    }

    public Long getID_Registration() {
        return ID_Registration;
    }

    public void setID_Registration(Long ID_Registration) {
        this.ID_Registration = ID_Registration;
    }

    public String getDate_Reg() {
        return Date_Reg;
    }

    public void setDate_Reg(String date_Reg) {
        Date_Reg = date_Reg;
    }

    public String getTime_Reg() {
        return Time_Reg;
    }

    public void setTime_Reg(String time_Reg) {
        Time_Reg = time_Reg;
    }

    public Employee getID_Employee() {
        return ID_Employee;
    }

    public void setID_Employee(Employee ID_Employee) {
        this.ID_Employee = ID_Employee;
    }

    public Patient getID_Patient() {
        return ID_Patient;
    }

    public void setID_Patient(Patient ID_Patient) {
        this.ID_Patient = ID_Patient;
    }

    public String getDes_Symptoms() {
        return Des_Symptoms;
    }

    public void setDes_Symptoms(String desSymptoms) {
        Des_Symptoms = desSymptoms;
    }
}
