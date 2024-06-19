package com.example.demo.employee;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    //@Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    private @Id Integer id;

    //private @Id Integer dNumber;

    //@Column(name = "dName")
    private String dName;

    public Department() {
    }

    public Department(Integer id, String dName) {
        this.id = id;
        this.dName = dName;
    }

    public Integer getId() {
        return id;
    }

    public String getdName() {
        return dName;
    }

    public void setId(Integer dNumber) {
        this.id = dNumber;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
