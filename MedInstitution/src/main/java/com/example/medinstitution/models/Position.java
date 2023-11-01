package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Position {

    @SerializedName("id_Position")
    private Long ID_Position;

    @SerializedName("position_Name")
    private String Position_Name;

    //public Position() {}

    public Position(Long ID_Position, String position_Name) {
        this.ID_Position = ID_Position;
        Position_Name = position_Name;
    }

    public Long getID_Position() {
        return ID_Position;
    }

    public void setID_Position(Long ID_Position) {
        this.ID_Position = ID_Position;
    }

    public String getPosition_Name() {
        return Position_Name;
    }

    public void setPosition_Name(String position_Name) {
        Position_Name = position_Name;
    }
}
