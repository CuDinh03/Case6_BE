package com.example.casestudy6.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int status;
    @OneToOne
    private Account account;

    public Likes() {
    }

    public Likes(Long id, Account account) {
        this.id = id;
        this.account = account;
    }
}
