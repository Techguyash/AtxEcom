package com.atx.atxecom.services;

import com.atx.atxecom.dto.appUsers.CreateAppUserDto;
import com.atx.atxecom.dto.appUsers.AppOtpDTO;
import com.atx.atxecom.entity.AppUser;
import com.atx.atxecom.entity.AppUserDTO;
import com.atx.atxecom.repository.AppUserRepo;
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
    private final AppOtpService appOtpService;

    @Override
    public CreateAppUserDto createAppUser(AppUser appUser)
    {
        AppUser availableUser = appUserRepo.findByEmail(appUser.getEmail());
        if(availableUser != null)
        {
            throw new RuntimeException("User already exists");
        }
        AppUser mappedUser = modelMapper.map(appUser, AppUser.class);
        mappedUser.setCreatedDate(LocalDateTime.now());
        AppUser savedUser = appUserRepo.save(mappedUser);
        AppOtpDTO generatedOtp = appOtpService.generateOtp(savedUser.getUserId(), "new user email");
        CreateAppUserDto responseEntity = modelMapper.map(savedUser, CreateAppUserDto.class);
        responseEntity.setOtp(generatedOtp.getOtpCode());
        return responseEntity;
    }



    @Override
    public AppUserDTO updateUser(AppUser appUser)
    {
        AppUser availableUser = appUserRepo.findByEmail(appUser.getEmail());
        if(availableUser != null)
        {
            throw new RuntimeException("User already exists");
        }
        modelMapper.map(availableUser,appUser);
        AppUser savedUser = appUserRepo.save(availableUser);
        return  modelMapper.map(savedUser, AppUserDTO.class);
    }

    @Override
    public AppUserDTO getUserById(Long id)
    {
        AppUser savedUser = appUserRepo.findByUserId(id);
        return modelMapper.map(savedUser, AppUserDTO.class);
    }

    @Override
    public AppUserDTO getUserByEmail(String email)
    {
        AppUser byEmail = appUserRepo.findByEmail(email);
        return modelMapper.map(byEmail, AppUserDTO.class);
    }

    @Override
    public List<AppUserDTO> getAllUsers()
    {
        List<AppUser> allUsers = appUserRepo.findAll();
        List<AppUserDTO> mappedUserDto = allUsers.stream().map(appUser -> modelMapper.map(appUser, AppUserDTO.class)).collect(
                Collectors.toList());
        return mappedUserDto;
    }


}
