package com.example.casestudy6.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime postDay;
    private int status;
    @ManyToOne
    private Account account;
    @OneToMany
    private List<Img> img;
    @OneToMany
    private Set<Comment> comment;
    @OneToMany
    private Set<Likes> likes;

    public Status() {
    }

    public Status(Long id, String content, LocalDateTime postDay, int status, Account account, List<Img> img, Set<Comment> comment, Set<Likes> likes) {
        this.id = id;
        this.content = content;
        this.postDay = postDay;
        this.status = status;
        this.account = account;
        this.img = img;
        this.comment = comment;
        this.likes = likes;
    }
}
