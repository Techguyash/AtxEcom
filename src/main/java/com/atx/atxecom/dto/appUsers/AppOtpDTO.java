package com.atx.atxecom.dto.appUsers;

import com.atx.atxecom.entity.AppOtp;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link AppOtp}
 */
@Value
public class AppOtpDTO implements Serializable
{
    private long otpId;
    private String otpCode;
    private LocalDateTime expiresAt;
    private long userId;
}