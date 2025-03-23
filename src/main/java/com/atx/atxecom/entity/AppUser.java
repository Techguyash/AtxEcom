package com.atx.atxecom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:55 am
 * @project AtxEcom
 **/
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class AppUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String phoneNo;
    @OneToMany(mappedBy = "appuser", orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Address> addresses = new LinkedHashSet<>();
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean isActive = false;
    private boolean isMailVerified = false;
    private boolean isPhoneVerified = false;
}
