package com.example.casestudy6.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int status;
    private String text;
    @ManyToOne
    private Account account;
    @OneToMany
     private Set<Likes> likes;

    public Comment() {
    }

    public Comment(Long id, int status, String text, Account account, Set<Likes> likes) {
        this.id = id;
        this.status = status;
        this.text = text;
        this.account = account;
        this.likes = likes;
    }
}
