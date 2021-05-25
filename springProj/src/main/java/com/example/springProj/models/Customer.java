package com.example.springProj.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String login;
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="busket_id")
    private Busket busket;
}
