package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;
import retrofit2.http.DELETE;

public class Medical_Card {

    @SerializedName(value = "id_Med_Card")
    private Long ID_Med_Card;

    @SerializedName(value = "num_Card")
    private String Num_Card;

    @SerializedName(value = "id_Pat_Card")
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
