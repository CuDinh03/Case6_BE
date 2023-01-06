package com.example.casestudy6.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long account1;
    @ManyToOne
    private Account account2;
    private int status;


}
