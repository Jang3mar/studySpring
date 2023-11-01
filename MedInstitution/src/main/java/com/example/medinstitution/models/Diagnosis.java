package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Diagnosis {

    @SerializedName(value = "id_Diagnosis")
    private Long ID_Diagnosis;

    @SerializedName(value = "icd_Code")
    private String ICD_Code;

    @SerializedName(value = "name_Diagnosis")
    private String Name_Diagnosis;

    public Diagnosis() {}

    public Diagnosis(Long ID_Diagnosis, String ICD_Code, String name_Diagnosis) {
        this.ID_Diagnosis = ID_Diagnosis;
        this.ICD_Code = ICD_Code;
        Name_Diagnosis = name_Diagnosis;
    }

    public Long getID_Diagnosis() {
        return ID_Diagnosis;
    }

    public void setID_Diagnosis(Long ID_Diagnosis) {
        this.ID_Diagnosis = ID_Diagnosis;
    }

    public String getICD_Code() {
        return ICD_Code;
    }

    public void setICD_Code(String ICD_Code) {
        this.ICD_Code = ICD_Code;
    }

    public String getName_Diagnosis() {
        return Name_Diagnosis;
    }

    public void setName_Diagnosis(String name_Diagnosis) {
        Name_Diagnosis = name_Diagnosis;
    }
}
