package com.atx.atxecom.controller;

import com.atx.atxecom.dto.CreateAppUserDto;
import com.atx.atxecom.entity.AppUser;
import com.atx.atxecom.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 2:20 pm
 * @project AtxEcom
 **/
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AppUserController
{
    private final AppUserService appUserService;

    @PostMapping
    public AppUser addUser(@RequestBody CreateAppUserDto appUser)
    {
        return appUserService.createAppUser(appUser);
    }

    @GetMapping("/{id}")
    public AppUser getUsers(@PathVariable long id){
        return appUserService.getUserById(id);
    }

    @GetMapping
    public List<AppUser> getAllUsers()
    {
        return appUserService.getAllUsers();
    }
}
