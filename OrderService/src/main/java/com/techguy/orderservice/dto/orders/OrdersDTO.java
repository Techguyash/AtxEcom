package com.techguy.orderservice.dto.orders;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Orders}
 */
@Data
public class OrdersDTO implements Serializable
{
    private long orderId;
    private long userId;
    private double cartValue;
    private List<OrderItemsDto> orderItems;
    private double discountAmount;
    private double paymentAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String transactionId;
    private LocalDateTime paymentDate;
    private String paymentCurrency;
    private String trackingNumber;
    private long addressId;
}