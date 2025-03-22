package com.atx.atxecom.repository;

import com.atx.atxecom.entity.AppOtp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ashiq
 * @createdOn 22/03/25 12:49 pm
 * @project AtxEcom
 **/
public interface AppOtpRepo extends JpaRepository<AppOtp, Long>
{
    AppOtp findByUserId_UserIdAndActiveTrue(long userId);



}
