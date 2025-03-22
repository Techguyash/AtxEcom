package com.atx.atxecom.entity;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link AppUser}
 */
@Data
public class AppUserDTO implements Serializable
{
    long userId;
    String firstName;
    String lastName;
    String email;
    String phoneNo;
    Set<AddressDto> addresses;
    LocalDateTime createdDate;
    LocalDateTime modifiedDate;
    boolean isActive;
    boolean isMailVerified;
    boolean isPhoneVerified;

    /**
     * DTO for {@link Address}
     */
    @Data
    public static class AddressDto implements Serializable
    {
        long AddressId;
        String addressLine1;
        String addressLine2;
        String city;
        String state;
        String country;
        String postalCode;
    }
}