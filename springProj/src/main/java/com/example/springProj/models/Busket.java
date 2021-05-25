package com.example.springProj.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Busket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "busket",cascade = CascadeType.MERGE)
    private List <OrderLine> orderLine;

    @OneToOne(mappedBy = "busket",cascade = CascadeType.ALL)
    private Customer customer;

    public Busket(){}

}
