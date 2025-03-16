package com.atx.atxecom.repository;

import com.atx.atxecom.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:44 pm
 * @project AtxEcom
 **/
public interface AppUserRepo extends JpaRepository<AppUser, Long>
{
    AppUser findByUserId(long userId);

    @Query("select a from AppUser a where a.email = ?1")
    AppUser findByEmail(String email);


}
