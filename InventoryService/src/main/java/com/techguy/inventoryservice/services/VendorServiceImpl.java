package com.techguy.inventoryservice.services;


import com.techguy.inventoryservice.dto.VendorDTO;
import com.techguy.inventoryservice.entity.Vendor;
import com.techguy.inventoryservice.exception.NoDataFoundException;
import com.techguy.inventoryservice.repository.VendorRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ashiq
 * @createdOn 16/03/25 11:27 am
 * @project AtxEcom
 **/
@Service
@Data
@AllArgsConstructor
public class VendorServiceImpl implements VendorService
{
    private VendorRepo vendorRepo;
    private ModelMapper modelMapper;

    @Override
    public VendorDTO addVendor(VendorDTO vendorDTO)
    {
        Vendor mappedVendor = modelMapper.map(vendorDTO, Vendor.class);
        Vendor savedEntity = vendorRepo.save(mappedVendor);
        return modelMapper.map(savedEntity, VendorDTO.class);
    }

    @Override
    public VendorDTO updateVendor(VendorDTO vendorDTO)
    {
        Vendor existingVendor = vendorRepo.findById(vendorDTO.getVendorId()).orElseThrow(
                () -> new NoDataFoundException("Vendor with id" + vendorDTO.getVendorId() + " not found"));
         modelMapper.map(vendorDTO, existingVendor);
        Vendor savedEntity = vendorRepo.save(existingVendor);
        return modelMapper.map(savedEntity, VendorDTO.class);
    }

    @Override
    public void deleteVendor(long id)
    {
            vendorRepo.findById(id).orElseThrow(()->new NoDataFoundException("No Vendor with id" + id));
            vendorRepo.deleteById(id);
    }

    @Override
    public VendorDTO getVendorById(long id)
    {
        return vendorRepo.findById(id).map((element) -> modelMapper.map(element, VendorDTO.class)).get();
    }

    @Override
    public List<VendorDTO> getVendors()
    {
        return vendorRepo.findAll().stream().map((element) -> modelMapper.map(element, VendorDTO.class)).collect(
                Collectors.toList());
    }
}
