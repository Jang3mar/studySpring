package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Patient_Category")
public class Patient_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Category;

    @Column(name = "Category_Name", nullable = false)
    private String Category_Name;

    @Column(name = "Sup_Certificate", nullable = false)
    private String Sup_Certificate;

    @Column(name = "Num_Certificate", nullable = false)
    private String Num_Certificate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Patient", nullable = false)
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
