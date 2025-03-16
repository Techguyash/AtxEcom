package com.atx.atxecom.services;

import com.atx.atxecom.dto.CreateAppUserDto;
import com.atx.atxecom.entity.AppUser;

import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 2:10 pm
 * @project AtxEcom
 **/
public interface AppUserService
{
    AppUser createAppUser(CreateAppUserDto appUser);

    AppUser updateUser(AppUser appUser);

    AppUser getUserById(Long id);

    AppUser getUserByEmail(String email);

    List<AppUser> getAllUsers();

}
