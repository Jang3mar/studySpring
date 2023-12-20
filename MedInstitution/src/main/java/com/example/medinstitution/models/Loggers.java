package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Loggers {

    @SerializedName(value = "id_Log")
    private Long id_log;

    @SerializedName(value = "log_Name")
    private String log_Name;

    @SerializedName(value = "date_Name")
    private String date_name;

    public Loggers() {}

    public Loggers(Long ID_Log, String log_Name, String date_Log) {
        this.id_log = ID_Log;
        this.log_Name = log_Name;
        this.date_name = date_Log;
    }

    public Long getId_log() {
        return id_log;
    }

    public void setId_log(Long id_log) {
        this.id_log = id_log;
    }

    public String getLog_Name() {
        return log_Name;
    }

    public void setLog_Name(String log_Name) {
        this.log_Name = log_Name;
    }

    public String getDate_name() {
        return date_name;
    }

    public void setDate_name(String date_name) {
        this.date_name = date_name;
    }
}
