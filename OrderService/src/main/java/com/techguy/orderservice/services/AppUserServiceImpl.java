package com.techguy.orderservice.services;


import com.techguy.orderservice.dto.appUsers.AppUserResDTO;
import com.techguy.orderservice.dto.appUsers.CreateUserReqDTO;
import com.techguy.orderservice.entity.AppUser;
import com.techguy.orderservice.repository.AppUserRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ashiq
 * @createdOn 16/03/25 2:11 pm
 * @project AtxEcom
 **/
@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService
{
    private final AppUserRepo appUserRepo;
    private final ModelMapper modelMapper;


    @Override
    public AppUserResDTO createAppUser(CreateUserReqDTO userReqDto)
    {
        AppUser availableUser = appUserRepo.findByEmail(userReqDto.getEmail());
        if(availableUser != null)
        {
            throw new RuntimeException("User already exists");
        }
        //encoding the password
        AppUser mappedUser = modelMapper.map(userReqDto, AppUser.class);
        mappedUser.setPasswordHash(userReqDto.getPassword());
        mappedUser.setCreatedDate(LocalDateTime.now());
        AppUser savedUser = appUserRepo.save(mappedUser);
        AppUserResDTO responseEntity = modelMapper.map(savedUser, AppUserResDTO.class);
        return responseEntity;
    }

    @Override
    public AppUserResDTO updateUser(AppUser appUser)
    {
        AppUser availableUser = appUserRepo.findByEmail(appUser.getEmail());
        if(availableUser != null)
        {
            throw new RuntimeException("User already exists");
        }
        modelMapper.map(availableUser,appUser);
        AppUser savedUser = appUserRepo.save(availableUser);
        return  modelMapper.map(savedUser, AppUserResDTO.class);
    }

    @Override
    public AppUserResDTO getUserById(Long id)
    {
        AppUser savedUser = appUserRepo.findByUserId(id);
        return modelMapper.map(savedUser, AppUserResDTO.class);
    }

    @Override
    public AppUserResDTO getUserByEmail(String email)
    {
        AppUser byEmail = appUserRepo.findByEmail(email);
        return modelMapper.map(byEmail, AppUserResDTO.class);
    }

    @Override
    public List<AppUserResDTO> getAllUsers()
    {
        List<AppUser> allUsers = appUserRepo.findAll();
        List<AppUserResDTO> mappedUserDto = allUsers.stream().map(appUser -> modelMapper.map(appUser, AppUserResDTO.class)).collect(
                Collectors.toList());
        return mappedUserDto;
    }



}
