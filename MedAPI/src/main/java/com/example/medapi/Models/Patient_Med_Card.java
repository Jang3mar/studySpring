package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Patient_Med_Card")
public class Patient_Med_Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Patient_Med_Card;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Med_Card", nullable = false)
    private Medical_Card ID_Med_Card_Ref;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Med_Reference", nullable = false)
    private Med_Reference ID_Ref_Med_Card;

    public Patient_Med_Card() {}

    public Patient_Med_Card(Long ID_Pat_Med_Card, Medical_Card ID_Med_Card_Ref, Med_Reference ID_Ref_Med_Card) {
        this.ID_Patient_Med_Card = ID_Pat_Med_Card;
        this.ID_Med_Card_Ref = ID_Med_Card_Ref;
        this.ID_Ref_Med_Card = ID_Ref_Med_Card;
    }

    public Long getID_Pat_Med_Card() {
        return ID_Patient_Med_Card;
    }

    public void setID_Pat_Med_Card(Long ID_Pat_Med_Card) {
        this.ID_Patient_Med_Card = ID_Pat_Med_Card;
    }

    public Medical_Card getID_Med_Card_Ref() {
        return ID_Med_Card_Ref;
    }

    public void setID_Med_Card_Ref(Medical_Card ID_Med_Card_Ref) {
        this.ID_Med_Card_Ref = ID_Med_Card_Ref;
    }

    public Med_Reference getID_Ref_Med_Card() {
        return ID_Ref_Med_Card;
    }

    public void setID_Ref_Med_Card(Med_Reference ID_Ref_Med_Card) {
        this.ID_Ref_Med_Card = ID_Ref_Med_Card;
    }
}
