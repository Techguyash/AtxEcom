package com.techguy.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:41 am
 * @project AtxEcom
 **/
@Entity
@Data
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser userId;
    private double cartValue;
    private double discountAmount;
    private double amountToBePaid;
    private LocalDateTime orderDate;
    private String paymentMethod;
    private String paymentStatus;
    private String transactionId;
    private LocalDateTime paymentDate;
    private String paymentCurrency;
    private String trackingNumber;
    @ManyToOne
    @JoinColumn(name = "Address_Id", nullable = false)
    private Address shippingAddress;
}
