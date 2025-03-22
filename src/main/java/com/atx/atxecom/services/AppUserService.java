package com.atx.atxecom.services;

import com.atx.atxecom.dto.appUsers.CreateUserRequestDTO;
import com.atx.atxecom.dto.appUsers.CreateUserResponseDTO;
import com.atx.atxecom.entity.AppUser;
import com.atx.atxecom.entity.AppUserDTO;

import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 2:10 pm
 * @project AtxEcom
 **/
public interface AppUserService
{
    CreateUserResponseDTO createAppUser(CreateUserRequestDTO appUser);

    AppUserDTO updateUser(AppUser appUser);

    AppUserDTO getUserById(Long id);

    AppUserDTO getUserByEmail(String email);

    List<AppUserDTO> getAllUsers();

}
