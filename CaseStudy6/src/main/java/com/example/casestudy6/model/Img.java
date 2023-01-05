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

    public Img() {
    }

    public Img(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
