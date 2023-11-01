package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Position_Employee")
public class Position_Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Position_Employee;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Employee", nullable = false)
    private Employee ID_Employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Position", nullable = false)
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

    public Employee getID_Employee() {
        return ID_Employee;
    }

    public void setID_Emp_Pos(Employee ID_Emp_Pos) {
        this.ID_Employee = ID_Emp_Pos;
    }

    public Position getID_Position() {
        return ID_Position;
    }

    public void setID_Pos_Emp(Position ID_Pos_Emp) {
        this.ID_Position = ID_Pos_Emp;
    }
}
