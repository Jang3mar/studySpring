package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Patient_Med_Card {

    @SerializedName(value = "id_Patient_Med_Card")
    private Long ID_Patient_Med_Card;

    @SerializedName(value = "id_Med_Card_Ref")
    private Medical_Card ID_Med_Card_Ref;

    @SerializedName(value = "id_Ref_Med_Card")
    private Med_Reference ID_Ref_Med_Card;

    public Patient_Med_Card(Long ID_Patient_Med_Card, Medical_Card ID_Med_Card_Ref, Med_Reference ID_Ref_Med_Card) {
        this.ID_Patient_Med_Card = ID_Patient_Med_Card;
        this.ID_Med_Card_Ref = ID_Med_Card_Ref;
        this.ID_Ref_Med_Card = ID_Ref_Med_Card;
    }

    public Long getID_Patient_Med_Card() {
        return ID_Patient_Med_Card;
    }

    public void setID_Patient_Med_Card(Long ID_Patient_Med_Card) {
        this.ID_Patient_Med_Card = ID_Patient_Med_Card;
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
