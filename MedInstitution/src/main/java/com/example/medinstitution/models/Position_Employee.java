package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Position_Employee {

    @SerializedName("id_Position_Employee")
    private Long ID_Position_Employee;

    @SerializedName("id_Employee")
    private Employee ID_Employee;

    @SerializedName("id_Position")
    private Position ID_Position;

    public Position_Employee() {}

    public Position_Employee(Long ID_Position_Employee, Employee ID_Emp_Pos, Position ID_Pos_Emp) {
        this.ID_Position_Employee = ID_Position_Employee;
        this.ID_Employee = ID_Emp_Pos;
        this.ID_Position = ID_Pos_Emp;
    }

    public Long getID_Position_Employee() {
        return ID_Position_Employee;
    }

    public void setID_Position_Employee(Long ID_Position_Employee) {
        this.ID_Position_Employee = ID_Position_Employee;
    }

    public Employee getID_Emp_Pos() {
        return ID_Employee;
    }

    public void setID_Emp_Pos(Employee ID_Emp_Pos) {
        this.ID_Employee = ID_Emp_Pos;
    }

    public Position getID_Pos_Emp() {
        return ID_Position;
    }

    public void setID_Pos_Emp(Position ID_Pos_Emp) {
        this.ID_Position = ID_Pos_Emp;
    }
}
