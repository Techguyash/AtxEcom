package com.techguy.orderservice.services;


import com.techguy.orderservice.dto.appUsers.AppUserResDTO;
import com.techguy.orderservice.dto.appUsers.CreateUserReqDTO;
import com.techguy.orderservice.entity.AppUser;

import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 2:10 pm
 * @project AtxEcom
 **/
public interface AppUserService
{
    AppUserResDTO createAppUser(CreateUserReqDTO appUser);

    AppUserResDTO updateUser(AppUser appUser);

    AppUserResDTO getUserById(Long id);

    AppUserResDTO getUserByEmail(String email);

    List<AppUserResDTO> getAllUsers();




}
