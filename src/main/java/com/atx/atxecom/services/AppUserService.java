package com.atx.atxecom.services;

import com.atx.atxecom.dto.appUsers.CreateUserReqDTO;
import com.atx.atxecom.dto.appUsers.AppUserResDTO;
import com.atx.atxecom.dto.appUsers.CreateUserResDTO;
import com.atx.atxecom.entity.AppUser;

import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 2:10 pm
 * @project AtxEcom
 **/
public interface AppUserService
{
    CreateUserResDTO createAppUser(CreateUserReqDTO appUser);

    AppUserResDTO updateUser(AppUser appUser);

    AppUserResDTO getUserById(Long id);

    AppUserResDTO getUserByEmail(String email);

    List<AppUserResDTO> getAllUsers();

}
