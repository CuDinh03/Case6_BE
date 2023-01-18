package com.example.casestudy6.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contentChat;
    @ManyToMany
    private Set<Account> account;
    private int status;

    public Chat() {
    }

    public Chat(Long id, String contentChat, Set<Account> account, int status) {
        this.id = id;
        this.contentChat = contentChat;
        this.account = account;
        this.status = status;
    }

    public Chat(String contentChat) {
        this.contentChat = contentChat;
    }
}
