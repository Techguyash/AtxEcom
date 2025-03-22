package com.atx.atxecom.services;

import com.atx.atxecom.dto.appUsers.AppOtpDTO;
import com.atx.atxecom.entity.AppOtp;
import com.atx.atxecom.entity.AppUser;
import com.atx.atxecom.exception.DataMismatchException;
import com.atx.atxecom.repository.AppOtpRepo;
import com.atx.atxecom.repository.AppUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

/**
 * @author ashiq
 * @createdOn 22/03/25 12:42 pm
 * @project AtxEcom
 **/
@Service
@AllArgsConstructor
public class AppOtpServiceImpl implements AppOtpService
{
    private static final int OTP_LENGTH = 6;
    private static final int EXPIRATION_TIME = 5;// 5 minutes
    private final SecureRandom random = new SecureRandom();

    private final AppUserRepo appUserRepo;
    private final AppOtpRepo appOtpRepo;



    @Override
    public AppOtpDTO generateOtp(long userId, String usageInfo)
    {
        //deactivate the old active otp
        AppOtp oldOtp = appOtpRepo.findByUserId_UserIdAndActiveTrue(userId);
        if(oldOtp != null)
        {
            oldOtp.setActive(Boolean.FALSE);
            appOtpRepo.save(oldOtp);
        }

        //create new otp with active status
        String otpCode = String.format("%06d", random.nextInt(1000000));
        AppUser foundUser = appUserRepo.findByUserId(userId);
        LocalDateTime createdOn = LocalDateTime.now();
        LocalDateTime expiresAt=createdOn.plusMinutes(EXPIRATION_TIME);
        AppOtp appOtp = new AppOtp(otpCode, createdOn, expiresAt, usageInfo, foundUser,Boolean.TRUE);
        AppOtp savedOtp = appOtpRepo.save(appOtp);
        AppOtpDTO appOtpDTO= new AppOtpDTO(savedOtp.getOtpId(),otpCode,expiresAt,foundUser.getUserId());
        return appOtpDTO;
    }

    @Override
    public String verifyOtp(long userId, String otpInput)
    {
        AppUser userEntity = appUserRepo.findByUserId(userId);
        AppOtp otpEntity = appOtpRepo.findByUserId_UserIdAndActiveTrue(userId);
        if(otpEntity != null && !otpEntity.isActive())
        {
            throw new DataMismatchException("OTP expired, generate new OTP");
        }
        else if(otpEntity!=null && otpEntity.getExpiresAt().isBefore(LocalDateTime.now()))
        {
            otpEntity.setActive(Boolean.FALSE);
            appOtpRepo.save(otpEntity);
            throw new DataMismatchException("OTP expired");

        }
        else if(!otpEntity.isActive())
        {
            throw new DataMismatchException("OTP is not active");
        }
        else if(!otpEntity.getOtpCode().equals(otpInput) )
        {
            throw new DataMismatchException("OTP mismatch");

        }
        userEntity.setMailVerified(Boolean.TRUE);
        userEntity.setActive(Boolean.TRUE);
        otpEntity.setVerified(Boolean.TRUE);
        otpEntity.setVerifiedAt(LocalDateTime.now());
        otpEntity.setActive(Boolean.FALSE);
        appOtpRepo.save(otpEntity);
        appUserRepo.save(userEntity);
        return "Verified";
    }
}
