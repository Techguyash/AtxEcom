package com.atx.atxecom.services;

import com.atx.atxecom.dto.CreateAppUserDto;
import com.atx.atxecom.entity.AppUser;
import com.atx.atxecom.repository.AppUserRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public AppUser createAppUser(CreateAppUserDto appUser)
    {
        AppUser availableUser = appUserRepo.findByEmail(appUser.getEmail());
        if(availableUser != null)
        {
            throw new RuntimeException("User already exists");
        }
        AppUser mappedUser = modelMapper.map(appUser, AppUser.class);

        return appUserRepo.save(mappedUser);
    }

    @Override
    public AppUser updateUser(AppUser appUser)
    {
        AppUser availableUser = appUserRepo.findByEmail(appUser.getEmail());
        if(availableUser != null)
        {
            throw new RuntimeException("User already exists");
        }
        modelMapper.map(availableUser,appUser);
        return appUserRepo.save(availableUser);
    }

    @Override
    public AppUser getUserById(Long id)
    {
        return appUserRepo.findByUserId(id);
    }

    @Override
    public AppUser getUserByEmail(String email)
    {
        return appUserRepo.findByEmail(email);
    }

    @Override
    public List<AppUser> getAllUsers()
    {
        return appUserRepo.findAll();
    }


}
