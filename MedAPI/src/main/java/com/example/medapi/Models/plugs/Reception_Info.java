package com.example.medapi.Models.plugs;

import com.example.medapi.Models.Diagnosis;
import com.example.medapi.Models.Reception;
import com.example.medapi.Models.Registration;
import jakarta.persistence.*;

public class Reception_Info {

    private Long ID_Reception;

    private String Date_Reception;

    private String Time_Reception;

    private String Status_Reception;

    private Long ID_Reg_Rec;

    private Long ID_Dig_Rec;

    public Reception_Info () {}

    public Reception_Info(Long ID_Reception, String date_Reception, String time_Reception, String status_Reception, Long ID_Reg_Rec, Long ID_Dig_Rec) {
        this.ID_Reception = ID_Reception;
        Date_Reception = date_Reception;
        Time_Reception = time_Reception;
        Status_Reception = status_Reception;
        this.ID_Reg_Rec = ID_Reg_Rec;
        this.ID_Dig_Rec = ID_Dig_Rec;
    }

    public Long getID_Reception() {
        return ID_Reception;
    }

    public void setID_Reception(Long ID_Reception) {
        this.ID_Reception = ID_Reception;
    }

    public String getDate_Reception() {
        return Date_Reception;
    }

    public void setDate_Reception(String date_Reception) {
        Date_Reception = date_Reception;
    }

    public String getTime_Reception() {
        return Time_Reception;
    }

    public void setTime_Reception(String time_Reception) {
        Time_Reception = time_Reception;
    }

    public String getStatus_Reception() {
        return Status_Reception;
    }

    public void setStatus_Reception(String status_Reception) {
        Status_Reception = status_Reception;
    }

    public Long getID_Reg_Rec() {
        return ID_Reg_Rec;
    }

    public void setID_Reg_Rec(Long ID_Reg_Rec) {
        this.ID_Reg_Rec = ID_Reg_Rec;
    }

    public Long getID_Dig_Rec() {
        return ID_Dig_Rec;
    }

    public void setID_Dig_Rec(Long ID_Dig_Rec) {
        this.ID_Dig_Rec = ID_Dig_Rec;
    }
}
