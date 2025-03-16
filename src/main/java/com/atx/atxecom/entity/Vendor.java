package com.atx.atxecom.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:21 am
 * @project AtxEcom
 **/
@Entity
@Data
public class Vendor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;
    @Schema(description = "Name of the Vendor")
    private String vendorName;
    @Schema(description = "Address of the Vendor")
    private String vendorAddress;
    @Schema(description = "Phone number of the Vendor")
    private String vendorPhone;
    @Schema(description = "email of the Vendor")
    private String vendorEmail;

}
