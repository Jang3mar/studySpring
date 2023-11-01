package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Document;

    @Column(name = "Series_Passport", nullable = false)
    private String Series_Passport;

    @Column(name = "Num_Passport", nullable = false)
    private String Num_Passport;

    @Column(name = "Date_Issue", nullable = false)
    private String Date_Issue;

    @Column(name = "Dep_Code", nullable = false)
    private String Dep_Code;

    @Column(name = "Issued_By", nullable = false)
    private String Issued_By;

    @Column(name = "Num_CMI", nullable = false)
    private String Num_CMI;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Patient", nullable = false)
    private Patient ID_Patient;

    public Document(){}

    public Document(Long ID_Document, String series_Passport, String num_Passport, String date_Issue, String dep_Code, String issued_By, String num_CMI, Patient ID_Patient_Doc) {
        this.ID_Document = ID_Document;
        Series_Passport = series_Passport;
        Num_Passport = num_Passport;
        Date_Issue = date_Issue;
        Dep_Code = dep_Code;
        Issued_By = issued_By;
        Num_CMI = num_CMI;
        this.ID_Patient = ID_Patient_Doc;
    }

    public Long getID_Document() {
        return ID_Document;
    }

    public void setID_Document(Long ID_Document) {
        this.ID_Document = ID_Document;
    }

    public String getSeries_Passport() {
        return Series_Passport;
    }

    public void setSeries_Passport(String series_Passport) {
        Series_Passport = series_Passport;
    }

    public String getNum_Passport() {
        return Num_Passport;
    }

    public void setNum_Passport(String num_Passport) {
        Num_Passport = num_Passport;
    }

    public String getDate_Issue() {
        return Date_Issue;
    }

    public void setDate_Issue(String date_Issue) {
        Date_Issue = date_Issue;
    }

    public String getDep_Code() {
        return Dep_Code;
    }

    public void setDep_Code(String dep_Code) {
        Dep_Code = dep_Code;
    }

    public String getIssued_By() {
        return Issued_By;
    }

    public void setIssued_By(String issued_By) {
        Issued_By = issued_By;
    }

    public String getNum_CMI() {
        return Num_CMI;
    }

    public void setNum_CMI(String num_CMI) {
        Num_CMI = num_CMI;
    }

    public Patient getID_Patient() {
        return ID_Patient;
    }

    public void setID_Patient(Patient ID_Patient_Doc) {
        this.ID_Patient = ID_Patient_Doc;
    }
}
