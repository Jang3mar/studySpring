package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Employee_Dep_Med {

    @SerializedName(value = "id_Employee_Dep_Med")
    private Long ID_Employee_Dep_Med;
    @SerializedName(value = "id_Emp_Dep")
    private Long ID_Emp_Dep;

    @SerializedName(value = "id_Dep_Med")
    private Long ID_Dep_Med;

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

    public Long getID_Dep_Med() {
        return ID_Dep_Med;
    }

    public void setID_Dep_Med(Long ID_Dep_Med) {
        this.ID_Dep_Med = ID_Dep_Med;
    }
}
