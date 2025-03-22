package com.atx.atxecom.dto.appUsers;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.atx.atxecom.entity.AppUser}
 */
public record NewUserDTO(long userId, String email, String phoneNo, LocalDateTime createdDate, boolean isActive,
                         boolean isMailVerified, boolean isPhoneVerified)
        implements Serializable
{
}