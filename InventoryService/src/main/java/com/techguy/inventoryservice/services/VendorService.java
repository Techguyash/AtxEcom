package com.techguy.inventoryservice.services;



import com.techguy.inventoryservice.dto.VendorReqDto;
import com.techguy.inventoryservice.dto.VendorResDto;

import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:25 am
 * @project AtxEcom
 **/
public interface VendorService
{
    VendorResDto addVendor(VendorReqDto vendorDTO);

    VendorResDto updateVendor(Long vendorId,VendorReqDto vendorDTO);

    void deleteVendor(long id);

    VendorResDto getVendorById(long id);

    List<VendorResDto> getVendors();
}
