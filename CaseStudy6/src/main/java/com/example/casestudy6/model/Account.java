package com.example.casestudy6.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String  email;
    private String fistName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Date birthDay;
    private String gender;
    @OneToOne
    private Img img;

    public Account() {
    }

    public Account(Long id, String userName, String password, String email, String fistName, String lastName, String phoneNumber, String address, Date birthDay, String gender, Img img) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthDay = birthDay;
        this.gender = gender;
        this.img = img;
    }
}
