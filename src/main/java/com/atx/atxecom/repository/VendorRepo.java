package com.atx.atxecom.repository;

import com.atx.atxecom.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:25 am
 * @project AtxEcom
 **/
@Repository
public interface VendorRepo extends JpaRepository<Vendor, Long>
{
}
