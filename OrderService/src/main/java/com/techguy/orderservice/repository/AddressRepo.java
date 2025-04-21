package com.techguy.orderservice.repository;


import com.techguy.orderservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:46 pm
 * @project AtxEcom
 **/
public interface AddressRepo extends JpaRepository<Address, Long>
{
}
