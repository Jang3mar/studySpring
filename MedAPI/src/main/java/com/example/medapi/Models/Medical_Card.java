package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Medical_Card")
public class Medical_Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Med_Card;

    @Column(name = "Num_Card", nullable = false)
    private String Num_Card;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Patient", nullable = false)
    private Patient ID_Pat_Card;

    public Long getID_Med_Card() {
        return ID_Med_Card;
    }

    public void setID_Med_Card(Long ID_Med_Card) {
        this.ID_Med_Card = ID_Med_Card;
    }

    public String getNum_Card() {
        return Num_Card;
    }

    public void setNum_Card(String num_Card) {
        Num_Card = num_Card;
    }

    public Patient getID_Pat_Card() {
        return ID_Pat_Card;
    }

    public void setID_Pat_Card(Patient ID_Pat_Card) {
        this.ID_Pat_Card = ID_Pat_Card;
    }
}
