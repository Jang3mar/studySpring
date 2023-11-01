package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Education {

    @SerializedName(value = "id_Education")
    private Long ID_Education;

    @SerializedName(value = "specialty")
    private String Specialty;

    @SerializedName(value = "end_Date")
    private String End_Date;

    @SerializedName(value = "diploma_Number")
    private String Diploma_Number;

    public Education() {}

    public Education(Long ID_Education, String specialty, String end_Date, String diploma_Number) {
        this.ID_Education = ID_Education;
        Specialty = specialty;
        End_Date = end_Date;
        Diploma_Number = diploma_Number;
    }

    public Long getID_Education() {return ID_Education;}

    public void setID_Education(Long ID_Education) {
        this.ID_Education = ID_Education;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public String getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(String end_Date) {
        End_Date = end_Date;
    }

    public String getDiploma_Number() {
        return Diploma_Number;
    }

    public void setDiploma_Number(String diploma_Number) {
        Diploma_Number = diploma_Number;
    }
}
