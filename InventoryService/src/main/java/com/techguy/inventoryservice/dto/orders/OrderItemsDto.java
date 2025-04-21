package com.techguy.inventoryservice.dto.orders;


import com.techguy.inventoryservice.entity.OrderItems;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link OrderItems}
 */
public record OrderItemsDto(@NotNull long productId, double unitPrice, int quantity)
        implements Serializable
{
}