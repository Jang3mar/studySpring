package com.example.medapi.Models.plugs;

import com.example.medapi.Models.Med_Reference;
import com.example.medapi.Models.Medical_Card;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Patient_Med_Card_Info {

    private Long ID_Pat_Med_Card;

    private Long ID_Med_Card_Ref;

    private Long ID_Ref_Med_Card;

    public Patient_Med_Card_Info(Long ID_Pat_Med_Card, Long ID_Med_Card_Ref, Long ID_Ref_Med_Card) {
        this.ID_Pat_Med_Card = ID_Pat_Med_Card;
        this.ID_Med_Card_Ref = ID_Med_Card_Ref;
        this.ID_Ref_Med_Card = ID_Ref_Med_Card;
    }

    public Long getID_Pat_Med_Card() {
        return ID_Pat_Med_Card;
    }

    public void setID_Pat_Med_Card(Long ID_Pat_Med_Card) {
        this.ID_Pat_Med_Card = ID_Pat_Med_Card;
    }

    public Long getID_Med_Card_Ref() {
        return ID_Med_Card_Ref;
    }

    public void setID_Med_Card_Ref(Long ID_Med_Card_Ref) {
        this.ID_Med_Card_Ref = ID_Med_Card_Ref;
    }

    public Long getID_Ref_Med_Card() {
        return ID_Ref_Med_Card;
    }

    public void setID_Ref_Med_Card(Long ID_Ref_Med_Card) {
        this.ID_Ref_Med_Card = ID_Ref_Med_Card;
    }
}
