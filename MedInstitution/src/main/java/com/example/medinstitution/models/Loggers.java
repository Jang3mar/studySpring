package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Loggers {

    @SerializedName(value = "id_log")
    private Long id_log;

    @SerializedName(value = "log_name")
    private String log_Name;

    @SerializedName(value = "datr_name")
    private String date_name;

    public Loggers() {}

    public Loggers(Long ID_Log, String log_Name, String date_Log) {
        this.id_log = ID_Log;
        this.log_Name = log_Name;
        this.date_name = date_Log;
    }

    public Long getID_Log() {
        return id_log;
    }

    public void setID_Log(Long ID_Log) {
        this.id_log = ID_Log;
    }

    public String getLog_Name() {
        return log_Name;
    }

    public void setLog_Name(String log_Name) {
        this.log_Name = log_Name;
    }

    public String getDate_Log() {
        return date_name;
    }

    public void setDate_Log(String date_Log) {
        this.date_name = date_Log;
    }

    //какие то еще данные нужны? время может? надо бы время тоже добавлять
}
