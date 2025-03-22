package com.atx.atxecom.services;

import com.atx.atxecom.dto.appUsers.AppOtpDTO;

/**
 * @author ashiq
 * @createdOn 22/03/25 12:38 pm
 * @project AtxEcom
 **/
public interface AppOtpService
{
    AppOtpDTO generateOtp(long userId,String usageInfo);

    String verifyOtp(long userId, String otpInput);
}
