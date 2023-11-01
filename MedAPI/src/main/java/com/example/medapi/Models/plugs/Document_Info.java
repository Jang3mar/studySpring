package com.example.medapi.Models.plugs;

import com.example.medapi.Models.Document;
import com.example.medapi.Models.Patient;
import jakarta.persistence.*;

public class Document_Info {

    private Long ID_Document;

    private String Series_Passport;

    private String Num_Passport;

    private String Date_Issue;

    private String Dep_Code;

    private String Issued_By;

    private String Num_CMI;

    private Long ID_Patient;

    public Document_Info(Document document) {
        this.ID_Document = document.getID_Document();
        Series_Passport = document.getSeries_Passport();
        Num_Passport = document.getNum_Passport();
        Date_Issue = document.getDate_Issue();
        Dep_Code = document.getDep_Code();
        Issued_By = document.getIssued_By();
        Num_CMI = document.getNum_CMI();
        this.ID_Patient = document.getID_Patient().getID_Patient();
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

    public Long getID_Patient() {
        return ID_Patient;
    }

    public void setID_Patient(Long ID_Patient_Doc) {
        this.ID_Patient = ID_Patient_Doc;
    }
}
