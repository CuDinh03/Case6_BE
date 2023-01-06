package com.example.casestudy6.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "user name không được để trống")
    private String userName;

    private int status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @Column(nullable = false)
    @NotBlank(message = "password không được để trống")
    private String password;

    @Column(unique = true, nullable = false)
    @Email
    @NotBlank(message = "email không để trống")
    private String email;

    private String fistName;
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "số điện thoại không được để trống")
    private String phoneNumber;
    private String address;

    @Past(message = "Ngày sinh phải trước thời gian hiện tại")
    @NotNull(message = "không được để trống")
    private Date birthDay;
    private String gender;
    @OneToOne
    private Img img;

    public Account() {
    }

    public Account(Long id, int status, Role role, String userName, String password, String email, String fistName, String lastName, String phoneNumber, String address, Date birthDay, String gender, Img img) {
        this.id = id;
        this.status = status;
        this.role = role;
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
