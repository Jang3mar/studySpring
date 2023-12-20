package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Reception")
public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Reception;

    @Column(name = "Date_Reception")
    private String Date_Reception;

    @Column(name = "Time_Reception")
    private String Time_Reception;

    @Column(name = "Status_Reception")
    private String Status_Reception;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Registration", nullable = false)
    private Registration id_registration;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Diagnosis", nullable = true)
    private Diagnosis id_diagnosis;

    public Reception() {}

    public Reception(Long ID_Reception, String date_Reception, String time_Reception, String status_Reception, Registration ID_Reg_Rec, Diagnosis ID_Dig_Rec) {
        this.ID_Reception = ID_Reception;
        Date_Reception = date_Reception;
        Time_Reception = time_Reception;
        Status_Reception = status_Reception;
        this.id_registration = ID_Reg_Rec;
        this.id_diagnosis = ID_Dig_Rec;
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

    public Registration getId_registration() {
        return id_registration;
    }

    public void setId_registration(Registration id_registration) {
        this.id_registration = id_registration;
    }

    public Diagnosis getId_diagnosis() {
        return id_diagnosis;
    }

    public void setId_diagnosis(Diagnosis id_diagnosis) {
        this.id_diagnosis = id_diagnosis;
    }
}
