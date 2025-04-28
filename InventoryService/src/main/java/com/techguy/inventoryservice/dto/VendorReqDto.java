package com.techguy.inventoryservice.dto;

import lombok.Data;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:26 am
 * @project AtxEcom
 **/
@Data
public class VendorReqDto
{
    private String vendorName;
    private String vendorAddress;
    private String vendorPhone;
    private String vendorEmail;
}
