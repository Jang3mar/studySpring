package com.example.medapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Education_Employee")
public class Education_Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Education_Employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Employee", nullable = false)
    private Employee ID_Emp_Edu;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Education", nullable = false)
    private Education ID_Edu_Emp;

    public Long getID_Education_Employee() {
        return ID_Education_Employee;
    }

    public void setID_Education_Employee(Long ID_Education_Employee) {
        this.ID_Education_Employee = ID_Education_Employee;
    }

    public Employee getID_Emp_Edu() {
        return ID_Emp_Edu;
    }

    public void setID_Emp_Edu(Employee ID_Emp_Edu) {
        this.ID_Emp_Edu = ID_Emp_Edu;
    }

    public Education getID_Edu_Emp() {
        return ID_Edu_Emp;
    }

    public void setID_Edu_Emp(Education ID_Edu_Emp) {
        this.ID_Edu_Emp = ID_Edu_Emp;
    }
}
