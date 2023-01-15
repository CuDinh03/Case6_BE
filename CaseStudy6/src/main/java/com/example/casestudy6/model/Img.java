package com.example.casestudy6.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int status;

    public Img() {
    }

    public Img(Long id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
