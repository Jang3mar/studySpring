package com.example.medinstitution.models.plugs;

import com.example.medinstitution.models.Employee;
import com.example.medinstitution.models.Patient;
import com.google.gson.annotations.SerializedName;

public class Registation_Info {

    private Long ID_Registration;
    private String Date_Reg;
    private String Time_Reg;
    private String Des_Symptoms;
    private Long ID_Emp_Reg;
    private Long ID_Pat_Reg;

    public Registation_Info(Long ID_Registration, String date_Reg, String time_Reg, String des_Symptoms, Long ID_Emp_Reg, Long ID_Pat_Reg) {
        this.ID_Registration = ID_Registration;
        Date_Reg = date_Reg;
        Time_Reg = time_Reg;
        Des_Symptoms = des_Symptoms;
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

    public String getDes_Symptoms() {
        return Des_Symptoms;
    }

    public void setDes_Symptoms(String des_Symptoms) {
        Des_Symptoms = des_Symptoms;
    }

    public Long getID_Emp_Reg() {
        return ID_Emp_Reg;
    }

    public void setID_Emp_Reg(Long ID_Emp_Reg) {
        this.ID_Emp_Reg = ID_Emp_Reg;
    }

    public Long getID_Pat_Reg() {
        return ID_Pat_Reg;
    }

    public void setID_Pat_Reg(Long ID_Pat_Reg) {
        this.ID_Pat_Reg = ID_Pat_Reg;
    }
}
