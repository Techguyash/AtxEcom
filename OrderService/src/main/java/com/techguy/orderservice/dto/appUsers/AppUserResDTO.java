package com.techguy.orderservice.dto.appUsers;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link AppUser}
 */
@Data
public class AppUserResDTO implements Serializable
{
    long userId;
    String firstName;
    String lastName;
    String email;
    String phoneNo;
    String otp;
    boolean isActive;
    boolean isMailVerified;
    boolean isPhoneVerified;
}