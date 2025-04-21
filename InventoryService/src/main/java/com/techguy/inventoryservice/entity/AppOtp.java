package com.techguy.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:14 pm
 * @project AtxEcom
 **/
@Entity
@Data
@NoArgsConstructor
public class AppOtp
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long otpId;
    private String otpCode;
    private LocalDateTime createdOn;
    private LocalDateTime expiresAt;
    private LocalDateTime verifiedAt;
    private String usage_info;
    private boolean active;
    private boolean verified;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser userId;

    public AppOtp(String otpCode, LocalDateTime createdOn, LocalDateTime expiresAt, String usage_info, AppUser userId,boolean active)
    {
        this.otpCode = otpCode;
        this.createdOn = createdOn;
        this.expiresAt = expiresAt;
        this.usage_info = usage_info;
        this.userId = userId;
        this.active = active;
    }
}
