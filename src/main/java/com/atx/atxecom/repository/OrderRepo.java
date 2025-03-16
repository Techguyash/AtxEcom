package com.atx.atxecom.repository;

import com.atx.atxecom.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:41 pm
 * @project AtxEcom
 **/
public interface OrderRepo extends JpaRepository<Orders, Long>
{
}
