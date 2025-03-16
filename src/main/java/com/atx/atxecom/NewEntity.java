package com.atx.atxecom;

import com.atx.atxecom.entity.AppOtp;
import com.atx.atxecom.entity.AppUser;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NewEntity extends AppUser
{
    @ManyToOne
    @JoinColumn(name = "app_otp_otp_id")
    private AppOtp appOtp;

}