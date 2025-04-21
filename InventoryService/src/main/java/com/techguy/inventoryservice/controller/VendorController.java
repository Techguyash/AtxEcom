package com.techguy.inventoryservice.controller;


import com.techguy.inventoryservice.apiResponse.APIResponse;
import com.techguy.inventoryservice.dto.VendorDTO;
import com.techguy.inventoryservice.services.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping
//    public ResponseEntity<APIResponse> getVendors()
//    {
//        List<VendorDTO> vendors = vendorService.getVendors();
//        APIResponse apiResponse = new APIResponse(vendors);
//        return ResponseEntity.ok(apiResponse);
//    }
//
//    @GetMapping
//    public ResponseEntity<APIResponse> getVendorById(@RequestParam("id") long id)
//    {
//        VendorDTO vendorById = vendorService.getVendorById(id);
//        APIResponse apiResponse = new APIResponse(vendorById);
//        return ResponseEntity.ok(apiResponse);
//    }

    @PostMapping
    public ResponseEntity<APIResponse> createVendor(@RequestBody VendorDTO vendorDTO)
    {
        VendorDTO vendorDto = vendorService.addVendor(vendorDTO);
        APIResponse apiResponse = new APIResponse(vendorDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateVendor(@RequestBody VendorDTO vendorDTO)
    {
        VendorDTO vendorDto = vendorService.updateVendor(vendorDTO);
        APIResponse apiResponse = new APIResponse(vendorDto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping
    public ResponseEntity<APIResponse> deleteVendor(@PathVariable Long vendorId)
    {
        vendorService.deleteVendor(vendorId);
        APIResponse apiResponse = new APIResponse("Successfully deleted vendor");
        return ResponseEntity.ok(apiResponse);

    }
}
