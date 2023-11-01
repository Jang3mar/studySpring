package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "DepartmentMed")
public class DepartmentMed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Dep_Med;

    @Column(name = "Department_Name", nullable = false)
    private String Department_Name;

    public DepartmentMed() {}

    public DepartmentMed(Long ID_Dep_Med, String department_Name) {
        this.ID_Dep_Med = ID_Dep_Med;
        Department_Name = department_Name;
    }

    public Long getID_Dep_Med() {
        return ID_Dep_Med;
    }

    public void setID_Dep_Med(Long ID_Dep_Med) {
        this.ID_Dep_Med = ID_Dep_Med;
    }

    public String getDepartment_Name() {
        return Department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        Department_Name = department_Name;
    }
}
