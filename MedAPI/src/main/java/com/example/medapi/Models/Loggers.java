package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Loggers")
public class Loggers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Log;

    @Column(name = "log_name", nullable = false)
    private String log_Name;

    @Column(name = "date_name", nullable = false)
    private String date_Name;

    public Loggers() {}

    public Loggers(Long ID_Log, String log_Name, String date_Name) {
        this.id_Log = ID_Log;
        this.log_Name = log_Name;
        this.date_Name = date_Name;
    }

    public Long getId_Log() {
        return id_Log;
    }

    public void setId_Log(Long id_Log) {
        this.id_Log = id_Log;
    }

    public String getLog_Name() {
        return log_Name;
    }

    public void setLog_Name(String log_Name) {
        this.log_Name = log_Name;
    }

    public String getDate_Name() {
        return date_Name;
    }

    public void setDate_Name(String date_Name) {
        this.date_Name = date_Name;
    }
}
