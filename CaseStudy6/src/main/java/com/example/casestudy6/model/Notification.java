package com.example.casestudy6.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Status status;
    @OneToOne
    private Friends friends;
    @ManyToOne
    private Likes likes;
    @ManyToOne
    private  Comment comment;

    public Notification() {
    }

    public Notification(Long id, String message, Account account, Status status, Friends friends, Likes likes, Comment comment) {
        this.id = id;
        this.message = message;
        this.account = account;
        this.status = status;
        this.friends = friends;
        this.likes = likes;
        this.comment = comment;
    }
}
