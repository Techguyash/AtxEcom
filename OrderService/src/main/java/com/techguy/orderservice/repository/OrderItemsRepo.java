package com.techguy.orderservice.repository;


import com.techguy.orderservice.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:59 pm
 * @project AtxEcom
 **/
public interface OrderItemsRepo extends JpaRepository<OrderItems, Long>
{
}
