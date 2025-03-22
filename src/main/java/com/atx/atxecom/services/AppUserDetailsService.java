package com.atx.atxecom.services;

import com.atx.atxecom.entity.AppUser;
import com.atx.atxecom.model.PrincipalUser;
import com.atx.atxecom.repository.AppUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ashiq
 * @createdOn 22/03/25 5:59 pm
 * @project AtxEcom
 **/
@Service
@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService
{
    private final AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        AppUser userEntity = appUserRepo.findByEmail(username);
        if(userEntity == null)
            throw new UsernameNotFoundException(username);

        return new PrincipalUser(userEntity);
    }
}
