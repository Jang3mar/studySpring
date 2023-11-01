package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Registration {

    @SerializedName(value = "id_Registration")
    private Long ID_Registration;

    @SerializedName(value = "date_Reg")
    private String Date_Reg;

    @SerializedName(value = "time_Reg")
    private String Time_Reg;

    @SerializedName(value = "id_Emp_Reg")
    private Employee ID_Emp_Reg;

    @SerializedName(value = "id_Pat_Reg")
    private Patient ID_Pat_Reg;

    public Registration() {}

    public Registration(Long ID_Registration, String date_Reg, String time_Reg, Employee ID_Emp_Reg, Patient ID_Pat_Reg) {
        this.ID_Registration = ID_Registration;
        Date_Reg = date_Reg;
        Time_Reg = time_Reg;
        this.ID_Emp_Reg = ID_Emp_Reg;
        this.ID_Pat_Reg = ID_Pat_Reg;
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

    public Employee getID_Emp_Reg() {
        return ID_Emp_Reg;
    }

    public void setID_Emp_Reg(Employee ID_Emp_Reg) {
        this.ID_Emp_Reg = ID_Emp_Reg;
    }

    public Patient getID_Pat_Reg() {
        return ID_Pat_Reg;
    }

    public void setID_Pat_Reg(Patient ID_Pat_Reg) {
        this.ID_Pat_Reg = ID_Pat_Reg;
    }
}
