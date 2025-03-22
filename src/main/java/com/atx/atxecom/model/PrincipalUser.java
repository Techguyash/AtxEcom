package com.atx.atxecom.model;

import com.atx.atxecom.entity.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ashiq
 * @createdOn 22/03/25 6:05 pm
 * @project AtxEcom
 **/
@AllArgsConstructor
public class PrincipalUser implements UserDetails
{
    private AppUser appUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword()
    {
        return appUser.getPasswordHash();
    }

    @Override
    public String getUsername()
    {
        return appUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }
    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return appUser.isActive();
    }
}
