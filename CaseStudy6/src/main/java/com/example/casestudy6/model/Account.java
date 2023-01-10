package com.example.casestudy6.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column(nullable = false)
    @NotBlank(message = "password không được để trống")
    private String password;

    @Column(unique = true, nullable = false)
    @Email
    @NotBlank(message = "email không để trống")
    private String email;

    private String firstName;
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "số điện thoại không được để trống")
    private String phoneNumber;
    private String address;

    @Past(message = "Ngày sinh phải trước thời gian hiện tại")
//    @NotNull(message = "không được để trống")
    private Date birthDay;
    private String gender;
    @OneToOne
    private Img img;

    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    public Account() {
    }

}
