package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Patient;

    @Column(name = "Second_Patient", nullable = false)
    private String Second_Patient;

    @Column(name = "First_Patient", nullable = false)
    private String First_Patient;

    @Column(name = "Middle_Patient")
    private String Middle_Patient;

    @Column(name = "Login_Patient", nullable = false)
    private String Login_Patient;

    @Column(name = "Password_Patient", nullable = false)
    private String Password_Patient;

    @Column(name = "Birthday_Patient", nullable = false)
    private String Birthday_Patient;

    public Patient(){}

    public Patient(Long ID_Patient, String second_Patient, String first_Patient, String middle_Patient, String login_Patient, String password_Patient, String birthday_Patient) {
        this.ID_Patient = ID_Patient;
        Second_Patient = second_Patient;
        First_Patient = first_Patient;
        Middle_Patient = middle_Patient;
        Login_Patient = login_Patient;
        Password_Patient = password_Patient;
        Birthday_Patient = birthday_Patient;
    }

    public Long getID_Patient() {
        return ID_Patient;
    }

    public void setID_Patient(Long ID_Patient) {
        this.ID_Patient = ID_Patient;
    }

    public String getSecond_Patient() {
        return Second_Patient;
    }

    public void setSecond_Patient(String second_Patient) {
        Second_Patient = second_Patient;
    }

    public String getFirst_Patient() {
        return First_Patient;
    }

    public void setFirst_Patient(String first_Patient) {
        First_Patient = first_Patient;
    }

    public String getMiddle_Patient() {
        return Middle_Patient;
    }

    public void setMiddle_Patient(String middle_Patient) {
        Middle_Patient = middle_Patient;
    }

    public String getLogin_Patient() {
        return Login_Patient;
    }

    public void setLogin_Patient(String login_Patient) {
        Login_Patient = login_Patient;
    }

    public String getPassword_Patient() {
        return Password_Patient;
    }

    public void setPassword_Patient(String password_Patient) {
        Password_Patient = password_Patient;
    }

    public String getBirthday_Patient() {
        return Birthday_Patient;
    }

    public void setBirthday_Patient(String birthday_Patient) {
        Birthday_Patient = birthday_Patient;
    }
}
