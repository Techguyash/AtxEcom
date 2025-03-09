package com.atx.atxecom.repository;

import com.atx.atxecom.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ashiq
 * @createdOn 02/03/25 1:09 pm
 * @project AtxEcom
 **/
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>
{
}
