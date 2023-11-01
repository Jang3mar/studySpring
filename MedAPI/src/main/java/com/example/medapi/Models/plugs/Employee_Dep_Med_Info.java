package com.example.medapi.Models.plugs;

import com.example.medapi.Models.DepartmentMed;
import com.example.medapi.Models.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Employee_Dep_Med_Info {

    private Long ID_Employee_Dep_Med;
    private Long ID_Emp_Dep;
    private Long ID_Dep_Emp;

    public Employee_Dep_Med_Info(Long ID_Employee_Dep_Med, Long ID_Emp_Dep, Long ID_Dep_Emp) {
        this.ID_Employee_Dep_Med = ID_Employee_Dep_Med;
        this.ID_Emp_Dep = ID_Emp_Dep;
        this.ID_Dep_Emp = ID_Dep_Emp;
    }

    public Long getID_Employee_Dep_Med() {
        return ID_Employee_Dep_Med;
    }

    public void setID_Employee_Dep_Med(Long ID_Employee_Dep_Med) {
        this.ID_Employee_Dep_Med = ID_Employee_Dep_Med;
    }

    public Long getID_Emp_Dep() {
        return ID_Emp_Dep;
    }

    public void setID_Emp_Dep(Long ID_Emp_Dep) {
        this.ID_Emp_Dep = ID_Emp_Dep;
    }

    public Long getID_Dep_Emp() {
        return ID_Dep_Emp;
    }

    public void setID_Dep_Emp(Long ID_Dep_Emp) {
        this.ID_Dep_Emp = ID_Dep_Emp;
    }
}
