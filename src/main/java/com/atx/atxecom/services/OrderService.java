package com.atx.atxecom.services;

import com.atx.atxecom.dto.orders.OrdersDTO;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:34 pm
 * @project AtxEcom
 **/
public interface OrderService
{
    OrdersDTO createOrder(OrdersDTO ordersDTO);

    OrdersDTO updateOrder(OrdersDTO ordersDTO);

    OrdersDTO getOrderById(Long id);

    OrdersDTO getOrdersByUserId(Long userId);
}
