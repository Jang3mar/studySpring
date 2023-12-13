package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Loggers {

    @SerializedName(value = "idLog")
    private Long ID_Log;

    @SerializedName(value = "logName")
    private String log_Name;

    @SerializedName(value = "dateLog")
    private String date_Log;

    public Loggers() {}

    public Loggers(Long ID_Log, String log_Name, String date_Log) {
        this.ID_Log = ID_Log;
        this.log_Name = log_Name;
        this.date_Log = date_Log;
    }

    public Long getID_Log() {
        return ID_Log;
    }

    public void setID_Log(Long ID_Log) {
        this.ID_Log = ID_Log;
    }

    public String getLog_Name() {
        return log_Name;
    }

    public void setLog_Name(String log_Name) {
        this.log_Name = log_Name;
    }

    public String getDate_Log() {
        return date_Log;
    }

    public void setDate_Log(String date_Log) {
        this.date_Log = date_Log;
    }

    //какие то еще данные нужны? время может? надо бы время тоже добавлять
}
