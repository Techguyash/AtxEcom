package com.techguy.inventoryservice.services;


import com.techguy.inventoryservice.dto.VendorDTO;

import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:25 am
 * @project AtxEcom
 **/
public interface VendorService
{
    VendorDTO addVendor(VendorDTO vendorDTO);

    VendorDTO updateVendor(VendorDTO vendorDTO);

    void deleteVendor(long id);

    VendorDTO getVendorById(long id);

    List<VendorDTO> getVendors();
}
