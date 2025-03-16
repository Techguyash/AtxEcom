package com.atx.atxecom.dto;

import com.atx.atxecom.entity.AppUser;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link AppUser}
 */
@Value
public class CreateAppUserDto implements Serializable
{
    long userId;
    String firstName;
    String lastName;
    String email;
    String passwordHash;
    String phoneNo;
    boolean isActive;
    boolean isMailVerified;
    boolean isPhoneVerified;
}