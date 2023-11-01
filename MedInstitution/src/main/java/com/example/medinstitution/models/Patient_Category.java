package com.example.medinstitution.models;

import com.google.gson.annotations.SerializedName;

public class Patient_Category {

    @SerializedName(value = "id_Category")
    private Long ID_Category;

    @SerializedName(value = "category_Name")
    private String Category_Name;

    @SerializedName(value = "sup_Certificate")
    private String Sup_Certificate;

    @SerializedName(value = "num_Certificate")
    private String Num_Certificate;

    @SerializedName(value = "id_Pat_Cat")
    private Patient ID_Pat_Cat;

    public Patient_Category() {}

    public Patient_Category(Long ID_Category, String category_Name, String sup_Certificate, String num_Certificate, Patient ID_Pat_Cat) {
        this.ID_Category = ID_Category;
        Category_Name = category_Name;
        Sup_Certificate = sup_Certificate;
        Num_Certificate = num_Certificate;
        this.ID_Pat_Cat = ID_Pat_Cat;
    }

    public Long getID_Category() {
        return ID_Category;
    }

    public void setID_Category(Long ID_Category) {
        this.ID_Category = ID_Category;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public String getSup_Certificate() {
        return Sup_Certificate;
    }

    public void setSup_Certificate(String sup_Certificate) {
        Sup_Certificate = sup_Certificate;
    }

    public String getNum_Certificate() {
        return Num_Certificate;
    }

    public void setNum_Certificate(String num_Certificate) {
        Num_Certificate = num_Certificate;
    }

    public Patient getID_Pat_Cat() {
        return ID_Pat_Cat;
    }

    public void setID_Pat_Cat(Patient ID_Pat_Cat) {
        this.ID_Pat_Cat = ID_Pat_Cat;
    }
}
