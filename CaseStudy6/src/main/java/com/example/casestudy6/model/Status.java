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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostDay() {
        return postDay;
    }

    public void setPostDay(LocalDateTime postDay) {
        this.postDay = postDay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Img> getImg() {
        return img;
    }

    public void setImg(List<Img> img) {
        this.img = img;
    }

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }

    public Set<Likes> getLikes() {
        return likes;
    }

    public void setLikes(Set<Likes> likes) {
        this.likes = likes;
    }
}
