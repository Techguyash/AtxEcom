package com.atx.atxecom.dto.appUsers;

import com.atx.atxecom.entity.AppUser;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link AppUser}
 */
@Data
public class CreateAppUserDto implements Serializable
{
    long userId;
    String firstName;
    String lastName;
    String email;
    String passwordHash;
    String phoneNo;
    String otp;
    boolean isActive;
    boolean isMailVerified;
    boolean isPhoneVerified;
}