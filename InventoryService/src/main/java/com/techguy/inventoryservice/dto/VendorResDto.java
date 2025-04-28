package com.techguy.inventoryservice.dto;

import lombok.Data;

/**
 * @author ashiq
 * @createdOn 24/04/25 8:45 pm
 * @project AtxEcom
 **/
@Data
public class VendorResDto
{
    private Long vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhone;
    private String vendorEmail;
}
