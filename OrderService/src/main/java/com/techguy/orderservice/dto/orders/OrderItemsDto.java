package com.techguy.orderservice.dto.orders;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link OrderItems}
 */
public record OrderItemsDto(@NotNull long productId, double unitPrice, int quantity)
        implements Serializable
{
}