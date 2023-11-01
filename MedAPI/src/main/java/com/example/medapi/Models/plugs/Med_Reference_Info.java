package com.example.medapi.Models.plugs;

import com.example.medapi.Models.Reception;
import jakarta.persistence.*;

public class Med_Reference_Info {

    private Long ID_Med_Reference;
    private String Appointment;
    private String Description;
    private String Add_Info;
    private Long ID_Rec_Med;

    public Med_Reference_Info(Long ID_Med_Reference, String appointment, String description, String add_Info, Long ID_Rec_Med) {
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

    public Long getID_Rec_Med() {
        return ID_Rec_Med;
    }

    public void setID_Rec_Med(Long ID_Rec_Med) {
        this.ID_Rec_Med = ID_Rec_Med;
    }
}
