package com.atx.atxecom.controller;

import com.atx.atxecom.apiResponse.APIResponse;
import com.atx.atxecom.dto.appUsers.AppOtpDTO;
import com.atx.atxecom.dto.appUsers.CreateUserReqDTO;
import com.atx.atxecom.dto.appUsers.CreateUserResDTO;
import com.atx.atxecom.dto.appUsers.LoginReqDto;
import com.atx.atxecom.services.AppOtpService;
import com.atx.atxecom.services.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

/**
 * @author ashiq
 * @createdOn 23/03/25 4:45 am
 * @project AtxEcom
 **/
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController
{
    private final AppOtpService appOtpService;
    private final AppUserService appUserService;



    @Operation(
            summary = "Register and generate OTP for new User",
            description = "Register and generate OTP for new User."
    )
    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<APIResponse> loginUser(@RequestBody LoginReqDto loginDto)
    {


        String s = appUserService.loginUser(loginDto);
        APIResponse apiResponse = new APIResponse(s);
        return ResponseEntity.ok(apiResponse);
    }

    @Operation(
            summary = "Login User",
            description = "Login and generate JWT token for registered User"
    )
    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<APIResponse> registerUser(@RequestBody CreateUserReqDTO appUser)
    {
        CreateUserResDTO responseData = appUserService.createAppUser(appUser);
        APIResponse apiResponse = new APIResponse(responseData);
        return  ResponseEntity.ok(apiResponse);
    }

    @Operation(
            summary = "Verify OTP for User",
            description = "Verifies the OTP entered by the user and returns the validation status."
    )
    @PostMapping("/verify/{userId}/{inputOtp}")
    public ResponseEntity<APIResponse> verifyUser(@PathVariable long userId, @PathVariable String inputOtp)
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
