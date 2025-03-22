package com.atx.atxecom.controller;

import com.atx.atxecom.apiResponse.APIResponse;
import com.atx.atxecom.dto.appUsers.AppOtpDTO;
import com.atx.atxecom.dto.appUsers.CreateUserRequestDTO;
import com.atx.atxecom.dto.appUsers.CreateUserResponseDTO;
import com.atx.atxecom.entity.AppUser;
import com.atx.atxecom.entity.AppUserDTO;
import com.atx.atxecom.services.AppOtpService;
import com.atx.atxecom.services.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final AppOtpService appOtpService;

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<APIResponse> registerUser(@RequestBody CreateUserRequestDTO appUser)
    {
        CreateUserResponseDTO responseData = appUserService.createAppUser(appUser);
        APIResponse apiResponse = new APIResponse(responseData);
        return  ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getUsers(@PathVariable long id){
        AppUserDTO userById = appUserService.getUserById(id);
        APIResponse apiResponse = new APIResponse(userById);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllUsers()
    {
        List<AppUserDTO> allUsers = appUserService.getAllUsers();
        APIResponse apiResponse = new APIResponse(allUsers);
        return ResponseEntity.ok(apiResponse);
    }

    @Operation(
            summary = "Verify OTP for User",
            description = "Verifies the OTP entered by the user and returns the validation status."
    )
    @PostMapping("/verify/{userId}/{inputOtp}")
    public ResponseEntity<APIResponse> verifyUser(@PathVariable long userId,@PathVariable String inputOtp)
    {
        String response = appOtpService.verifyOtp(userId, inputOtp);
        APIResponse apiResponse = new APIResponse(response);
        return ResponseEntity.ok(apiResponse);
    }

    @Operation(
            summary = "Generate OTP for User",
            description = "Generate the OTP entered by the user and returns the new OTP"
    )
    @PostMapping("generateOTP/{userId}")
    public ResponseEntity<APIResponse> generateNewOtp(@PathVariable long userId)
    {
        AppOtpDTO generatedOtp = appOtpService.generateOtp(userId, "new user");
        APIResponse apiResponse = new APIResponse(generatedOtp);
        return ResponseEntity.ok(apiResponse);
    }
}
