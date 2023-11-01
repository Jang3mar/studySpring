package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Reception {

    @SerializedName(value = "id_Reception")
    private Long ID_Reception;

    @SerializedName(value = "date_Reception")
    private String Date_Reception;

    @SerializedName(value = "time_Reception")
    private String Time_Reception;

    @SerializedName(value = "status_Reception")
    private String Status_Reception;

    @SerializedName(value = "id_Reg_Rec")
    private Registration ID_Reg_Rec;

    @SerializedName(value = "id_Dig_Rec")
    private Diagnosis ID_Dig_Rec;

    public Reception() {}

    public Reception(Long ID_Reception, String date_Reception, String time_Reception, String status_Reception, Registration ID_Reg_Rec, Diagnosis ID_Dig_Rec) {
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

    public Registration getID_Reg_Rec() {
        return ID_Reg_Rec;
    }

    public void setID_Reg_Rec(Registration ID_Reg_Rec) {
        this.ID_Reg_Rec = ID_Reg_Rec;
    }

    public Diagnosis getID_Dig_Rec() {
        return ID_Dig_Rec;
    }

    public void setID_Dig_Rec(Diagnosis ID_Dig_Rec) {
        this.ID_Dig_Rec = ID_Dig_Rec;
    }
}
