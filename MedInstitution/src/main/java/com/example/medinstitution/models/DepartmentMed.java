package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class DepartmentMed {

    @SerializedName(value = "id_Dep_Med")
    private Long ID_Dep_Med;

    @SerializedName(value = "department_Name")
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
