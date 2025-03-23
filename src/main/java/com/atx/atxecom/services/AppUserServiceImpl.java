package com.atx.atxecom.services;


import com.atx.atxecom.dto.appUsers.*;
import com.atx.atxecom.entity.AppUser;
import com.atx.atxecom.repository.AppUserRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final JwtService jwtService;
    private final AuthenticationManager authManager;



    @Override
    public CreateUserResDTO createAppUser(CreateUserReqDTO userReqDto)
    {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);
        AppUser availableUser = appUserRepo.findByEmail(userReqDto.getEmail());
        if(availableUser != null)
        {
            throw new RuntimeException("User already exists");
        }
        //encoding the password
        String encodedPassword = passwordEncoder.encode(userReqDto.getPassword());
        AppUser mappedUser = modelMapper.map(userReqDto, AppUser.class);
        mappedUser.setPasswordHash(encodedPassword);
        mappedUser.setCreatedDate(LocalDateTime.now());
        AppUser savedUser = appUserRepo.save(mappedUser);
        AppOtpDTO generatedOtp = appOtpService.generateOtp(savedUser.getUserId(), "new user email");
        CreateUserResDTO responseEntity = modelMapper.map(savedUser, CreateUserResDTO.class);
        responseEntity.setOtp(generatedOtp.getOtpCode());
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

    @Override
    public String loginUser(LoginReqDto loginReqDto)
    {
        Authentication authObject = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReqDto.getEmail(), loginReqDto.getPassword()));
        if(authObject.isAuthenticated())
        {
        return jwtService.generateJwtToken(loginReqDto.getEmail());
        }
        return "Not Authenticated";
    }


}
