package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Registration;

    @Column(name = "Date_Reg", nullable = false)
    private String Date_Reg;

    @Column(name = "Time_Reg", nullable = false)
    private String Time_Reg;

    @Column(name = "Des_Symptoms", nullable = true)
    private String Des_Symptoms;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Employee", nullable = false)
    private Employee ID_Employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Patient", nullable = true)
    private Patient ID_Patient;

    public Registration() {}

    public Registration(Long ID_Registration, String date_Reg, String time_Reg, String Des_Symptoms, Employee ID_Emp_Reg, Patient ID_Pat_Reg) {
        this.ID_Registration = ID_Registration;
        Date_Reg = date_Reg;
        Time_Reg = time_Reg;
        this.Des_Symptoms = Des_Symptoms;
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

    public String getDes_Symptoms() {
        return Des_Symptoms;
    }

    public void setDes_Symptoms(String des_Symptoms) {
        Des_Symptoms = des_Symptoms;
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
}
