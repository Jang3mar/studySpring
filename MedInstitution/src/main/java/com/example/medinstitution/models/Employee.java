package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("id_Employee")
    private Long ID_Employee;

    @SerializedName("second_Employee")
    private String Second_Employee;

    @SerializedName("first_Employee")
    private String First_Employee;

    @SerializedName("middle_Employee")
    private String Middle_Employee;

    @SerializedName("birthday_Employee")
    private String Birthday_Employee;

    @SerializedName("login_Employee")
    private String Login_Employee;

    @SerializedName("password_Employee")
    private String Password_Employee;

    public Employee(Long ID_Employee, String second_Employee, String first_Employee, String middle_Employee, String birthday_Employee, String login_Employee, String password_Employee) {
        this.ID_Employee = ID_Employee;
        Second_Employee = second_Employee;
        First_Employee = first_Employee;
        Middle_Employee = middle_Employee;
        Birthday_Employee = birthday_Employee;
        Login_Employee = login_Employee;
        Password_Employee = password_Employee;
    }

    public Long getID_Employee() {return ID_Employee;}

    public void setID_Employee(Long ID_Employee) {
        this.ID_Employee = ID_Employee;
    }

    public String getSecond_Employee() {
        return Second_Employee;
    }

    public void setSecond_Employee(String second_Employee) {
        Second_Employee = second_Employee;
    }

    public String getFirst_Employee() {
        return First_Employee;
    }

    public void setFirst_Employee(String first_Employee) {
        First_Employee = first_Employee;
    }

    public String getMiddle_Employee() {
        return Middle_Employee;
    }

    public void setMiddle_Employee(String middle_Employee) {
        Middle_Employee = middle_Employee;
    }

    public String getBirthday_Employee() {
        return Birthday_Employee;
    }

    public void setBirthday_Employee(String birthday_Employee) {
        Birthday_Employee = birthday_Employee;
    }

    public String getLogin_Employee() {
        return Login_Employee;
    }

    public void setLogin_Employee(String login_Employee) {
        Login_Employee = login_Employee;
    }

    public String getPassword_Employee() {
        return Password_Employee;
    }

    public void setPassword_Employee(String password_Employee) {
        Password_Employee = password_Employee;
    }
}
