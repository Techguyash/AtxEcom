package com.techguy.orderservice.repository;


import com.techguy.orderservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ashiq
 * @createdOn 02/03/25 5:18 pm
 * @project AtxEcom
 **/
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>
{
    Product findByName(String name);
}
