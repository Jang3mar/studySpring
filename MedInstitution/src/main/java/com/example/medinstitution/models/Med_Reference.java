package com.example.medinstitution.models;


import com.google.gson.annotations.SerializedName;

public class Med_Reference {

    @SerializedName(value = "id_Med_Reference")
    private Long ID_Med_Reference;

    @SerializedName(value = "appointment")
    private String Appointment;

    @SerializedName(value = "description")
    private String Description;

    @SerializedName(value = "add_Info")
    private String Add_Info;

    @SerializedName(value = "id_Rec_Med")
    private Reception ID_Rec_Med;

    public Med_Reference() {}

    public Med_Reference(Long ID_Med_Reference, String appointment, String description, String add_Info, Reception ID_Rec_Med) {
        this.ID_Med_Reference = ID_Med_Reference;
        Appointment = appointment;
        Description = description;
        Add_Info = add_Info;
        this.ID_Rec_Med = ID_Rec_Med;
    }

    public Long getID_Med_Reference() {
        return ID_Med_Reference;
    }

    public void setID_Med_Reference(Long ID_Med_Reference) {
        this.ID_Med_Reference = ID_Med_Reference;
    }

    public String getAppointment() {
        return Appointment;
    }

    public void setAppointment(String appointment) {
        Appointment = appointment;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAdd_Info() {
        return Add_Info;
    }

    public void setAdd_Info(String add_Info) {
        Add_Info = add_Info;
    }

    public Reception getID_Rec() {
        return ID_Rec_Med;
    }

    public void setID_Rec(Reception ID_Rec) {
        this.ID_Rec_Med = ID_Rec;
    }
}
