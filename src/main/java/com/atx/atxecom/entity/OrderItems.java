package com.atx.atxecom.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class OrderItems
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderItemId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private double unitPrice;
    private int quantity;
    private double totalPrice;

}