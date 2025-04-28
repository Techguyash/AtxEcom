package com.techguy.inventoryservice.services;


import com.techguy.inventoryservice.dto.VendorReqDto;
import com.techguy.inventoryservice.dto.VendorResDto;
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
    public VendorResDto addVendor(VendorReqDto vendorDTO)
    {
        Vendor mappedVendor = modelMapper.map(vendorDTO, Vendor.class);
        Vendor savedEntity = vendorRepo.save(mappedVendor);
        return modelMapper.map(savedEntity, VendorResDto.class);
    }

    @Override
    public VendorResDto updateVendor(Long id,VendorReqDto vendorDTO)
    {
        Vendor existingVendor = vendorRepo.findById(id).orElseThrow(
                () -> new NoDataFoundException("Vendor with id" + id + " not found"));
         modelMapper.map(vendorDTO, existingVendor);
        Vendor savedEntity = vendorRepo.save(existingVendor);
        return modelMapper.map(savedEntity, VendorResDto.class);
    }

    @Override
    public void deleteVendor(long id)
    {
            vendorRepo.findById(id).orElseThrow(()->new NoDataFoundException("No Vendor with id" + id));
            vendorRepo.deleteById(id);
    }

    @Override
    public VendorResDto getVendorById(long id)
    {
        return vendorRepo.findById(id).map((element) -> modelMapper.map(element, VendorResDto.class)).get();
    }

    @Override
    public List<VendorResDto> getVendors()
    {
        return vendorRepo.findAll().stream().map((element) -> modelMapper.map(element, VendorResDto.class)).collect(
                Collectors.toList());
    }
}
