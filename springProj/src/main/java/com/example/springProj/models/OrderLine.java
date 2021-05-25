package com.example.springProj.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Item item;

    @ManyToOne
    @JoinColumn(name="busket_id")
    private Busket busket;

    private int count;

    public  OrderLine(Item item, int count){
        this.item=item;
        this.count=count;
    }

    public  OrderLine(Item item, int count,Busket busket){
        this.item=item;
        this.count=count;
        this.busket=busket;
    }

    public OrderLine(){}
}
