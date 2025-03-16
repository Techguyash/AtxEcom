package com.atx.atxecom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:14 pm
 * @project AtxEcom
 **/
@Entity
@Data
public class AppOtp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long otpId;
    private long otpCode;
    private LocalDateTime createdOn;
    private LocalDateTime expiresAt;
    private String usage;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser userId;
}
