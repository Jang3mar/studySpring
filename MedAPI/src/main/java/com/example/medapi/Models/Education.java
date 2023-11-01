package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Education;
    @Column(name = "Specialty", nullable = false)
    private String Specialty;
    @Column(name = "End_Date", nullable = false)
    private String End_Date;
    @Column(name = "Diploma_Number", nullable = false)
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
