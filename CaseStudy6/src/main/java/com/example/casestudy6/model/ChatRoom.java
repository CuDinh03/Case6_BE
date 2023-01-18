package com.example.casestudy6.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String accountName;
    private String content;

    public ChatRoom() {
    }

    public ChatRoom(Long id, String accountName, String content) {
        this.id = id;
        this.accountName = accountName;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
