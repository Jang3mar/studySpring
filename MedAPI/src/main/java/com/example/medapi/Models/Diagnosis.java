package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Diagnosis;

    @Column(name = "ICD_Code", nullable = false)
    private String ICD_Code;

    @Column(name = "Name_Diagnosis", nullable = false)
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
