package com.atx.atxecom.dto.orders;

import com.atx.atxecom.entity.OrderItems;
import com.atx.atxecom.entity.Product;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link OrderItems}
 */
public record OrderItemsDto(@NotNull long productId, double unitPrice, int quantity)
        implements Serializable
{
}