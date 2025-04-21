package com.techguy.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:50 am
 * @project AtxEcom
 **/
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long AddressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    @ManyToOne
    @JoinColumn(name = "appuser_user_id")
    private AppUser appuser;

}
