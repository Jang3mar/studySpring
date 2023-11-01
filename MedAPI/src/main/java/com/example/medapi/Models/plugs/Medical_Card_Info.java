package com.example.medapi.Models.plugs;

import com.example.medapi.Models.Patient;
import jakarta.persistence.*;

public class Medical_Card_Info {

    private Long ID_Med_Card;

    private String Num_Card;

    private Long ID_Pat_Card;

    public Medical_Card_Info(Long ID_Med_Card, String num_Card, Long ID_Pat_Card) {
        this.ID_Med_Card = ID_Med_Card;
        Num_Card = num_Card;
        this.ID_Pat_Card = ID_Pat_Card;
    }

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

    public Long getID_Pat_Card() {
        return ID_Pat_Card;
    }

    public void setID_Pat_Card(Long ID_Pat_Card) {
        this.ID_Pat_Card = ID_Pat_Card;
    }
}
