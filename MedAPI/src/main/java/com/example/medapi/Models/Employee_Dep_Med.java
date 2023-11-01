package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee_Dep_Med")
public class Employee_Dep_Med {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Employee_Dep_Med;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Employee", nullable = false)
    private Employee ID_Emp_Dep;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Dep_Med", nullable = false)
    private DepartmentMed ID_Dep_Emp;

    public Long getID_Employee_Dep_Med() {
        return ID_Employee_Dep_Med;
    }

    public void setID_Employee_Dep_Med(Long ID_Employee_Dep_Med) {
        this.ID_Employee_Dep_Med = ID_Employee_Dep_Med;
    }

    public Employee getID_Emp_Dep() {
        return ID_Emp_Dep;
    }

    public void setID_Emp_Dep(Employee ID_Emp_Dep) {
        this.ID_Emp_Dep = ID_Emp_Dep;
    }

    public DepartmentMed getID_Dep_Med() {
        return ID_Dep_Emp;
    }

    public void setID_Dep_Med(DepartmentMed ID_Dep_Med) {
        this.ID_Dep_Emp = ID_Dep_Med;
    }
}
