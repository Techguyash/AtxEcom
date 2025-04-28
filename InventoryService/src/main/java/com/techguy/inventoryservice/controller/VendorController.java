package com.techguy.inventoryservice.controller;


import com.techguy.inventoryservice.apiResponse.APIResponse;
import com.techguy.inventoryservice.dto.VendorReqDto;
import com.techguy.inventoryservice.dto.VendorResDto;
import com.techguy.inventoryservice.services.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:28 pm
 * @project AtxEcom
 **/
@RestController
@RequestMapping("/vendor")
@AllArgsConstructor
public class VendorController
{
    private final VendorService vendorService;

    @GetMapping
    public ResponseEntity<APIResponse> getVendors()
    {
        List<VendorResDto> vendors = vendorService.getVendors();
        APIResponse apiResponse = new APIResponse(vendors);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getVendorById(@PathVariable("id") long id)
    {
        VendorResDto vendorById = vendorService.getVendorById(id);
        APIResponse apiResponse = new APIResponse(vendorById);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createVendor(@RequestBody VendorReqDto vendorDTO)
    {
        VendorResDto vendorDto = vendorService.addVendor(vendorDTO);
        APIResponse apiResponse = new APIResponse(vendorDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{vendorId}")
    public ResponseEntity<APIResponse> updateVendor(@PathVariable("vendorId") long vendorId,@RequestBody VendorReqDto vendorDTO)
    {
        VendorResDto vendorDto = vendorService.updateVendor(vendorId,vendorDTO);
        APIResponse apiResponse = new APIResponse(vendorDto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<APIResponse> deleteVendor(@PathVariable Long vendorId)
    {
        vendorService.deleteVendor(vendorId);
        APIResponse apiResponse = new APIResponse("Successfully deleted vendor");
        return ResponseEntity.ok(apiResponse);

    }
}
