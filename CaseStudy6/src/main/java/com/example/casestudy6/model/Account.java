package com.example.casestudy6.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
