package com.example.medapi.Models.plugs;

import com.example.medapi.Models.Education;
import com.example.medapi.Models.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Education_Employee_Info {

    private Long ID_Education_Employee;

    private Long ID_Emp_Edu;

    private Long ID_Edu_Emp;

    public Education_Employee_Info(Long ID_Education_Employee, Long ID_Emp_Edu, Long ID_Edu_Emp) {
        this.ID_Education_Employee = ID_Education_Employee;
        this.ID_Emp_Edu = ID_Emp_Edu;
        this.ID_Edu_Emp = ID_Edu_Emp;
    }

    public Long getID_Education_Employee() {
        return ID_Education_Employee;
    }

    public void setID_Education_Employee(Long ID_Education_Employee) {
        this.ID_Education_Employee = ID_Education_Employee;
    }

    public Long getID_Emp_Edu() {
        return ID_Emp_Edu;
    }

    public void setID_Emp_Edu(Long ID_Emp_Edu) {
        this.ID_Emp_Edu = ID_Emp_Edu;
    }

    public Long getID_Edu_Emp() {
        return ID_Edu_Emp;
    }

    public void setID_Edu_Emp(Long ID_Edu_Emp) {
        this.ID_Edu_Emp = ID_Edu_Emp;
    }
}
