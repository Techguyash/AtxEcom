package com.techguy.orderservice.controller;


import com.techguy.orderservice.apiResponse.APIResponse;
import com.techguy.orderservice.dto.appUsers.AppUserResDTO;
import com.techguy.orderservice.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getUsers(@PathVariable long id){
        AppUserResDTO userById = appUserService.getUserById(id);
        APIResponse apiResponse = new APIResponse(userById);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllUsers()
    {
        List<AppUserResDTO> allUsers = appUserService.getAllUsers();
        APIResponse apiResponse = new APIResponse(allUsers);
        return ResponseEntity.ok(apiResponse);
    }


}
