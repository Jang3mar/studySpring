package com.example.medapi.Models.plugs;

import com.example.medapi.Models.Employee;
import com.example.medapi.Models.Position;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Position_Employee_Info {

    private Long ID_Position_Employee;
    private Long ID_Employee;
    private Long ID_Position;

    public Position_Employee_Info(Long ID_Position_Employee, Long ID_Employee, Long ID_Position) {
        this.ID_Position_Employee = ID_Position_Employee;
        this.ID_Employee = ID_Employee;
        this.ID_Position = ID_Position;
    }

    public Long getID_Position_Employee() {
        return ID_Position_Employee;
    }

    public void setID_Position_Employee(Long ID_Position_Employee) {
        this.ID_Position_Employee = ID_Position_Employee;
    }

    public Long getID_Employee() {
        return ID_Employee;
    }

    public void setID_Employee(Long ID_Employee) {
        this.ID_Employee = ID_Employee;
    }

    public Long getID_Position() {
        return ID_Position;
    }

    public void setID_Position(Long ID_Position) {
        this.ID_Position = ID_Position;
    }
}
