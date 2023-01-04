package com.example.casestudy6.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Friends {
    @Id
    private Long account1;
    @ManyToOne
    private Account account2;
    private String status;

    public Friends() {
    }

    public Friends(Long account1, Account account2, String status) {
        this.account1 = account1;
        this.account2 = account2;
        this.status = status;
    }
}
