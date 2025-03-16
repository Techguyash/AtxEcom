package com.atx.atxecom.repository;

import com.atx.atxecom.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:46 pm
 * @project AtxEcom
 **/
public interface AddressRepo extends JpaRepository<Address, Long>
{
}
