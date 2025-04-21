package com.techguy.inventoryservice.controller;


import com.techguy.inventoryservice.apiResponse.APIResponse;
import com.techguy.inventoryservice.dto.ProductReqDto;
import com.techguy.inventoryservice.dto.ProductResDto;
import com.techguy.inventoryservice.dto.RefilProductDTO;
import com.techguy.inventoryservice.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    //Create a new product
    @PostMapping
    public ResponseEntity<APIResponse> createProduct(@RequestBody ProductReqDto productResDto) {
        ProductResDto createdProduct=productService.createProduct(productResDto);
        APIResponse apiResponse = new APIResponse(createdProduct);
        return ResponseEntity.ok(apiResponse);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getProductById(@PathVariable Long id) {
        ProductResDto productResDto = productService.getProductById(id);
        APIResponse apiResponse = new APIResponse(productResDto);
        return ResponseEntity.ok(apiResponse);
    }

    // Get all products
    @GetMapping
    public ResponseEntity<APIResponse> getAllProducts() {
        List<ProductResDto> products = productService.getAllProducts();
        APIResponse apiResponse = new APIResponse(products);
        return ResponseEntity.ok(apiResponse);
    }

    // Update product
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateProduct(@PathVariable Long id, @RequestBody ProductReqDto productResDto) {
        ProductResDto updatedProduct = productService.updateProduct(id, productResDto);
        APIResponse apiResponse = new APIResponse(updatedProduct);
        return ResponseEntity.ok(apiResponse);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        APIResponse apiResponse = new APIResponse("Product deleted successfully");
        return ResponseEntity.ok(apiResponse);
    }

    @Operation(
            summary = "refill the stocks",
            description = "To refill stocks for the provided product id"
    )
    @PutMapping
    public ResponseEntity<APIResponse> refillStock(@RequestBody RefilProductDTO refilProductDTO)
    {
        ProductResDto productResDto =
                productService.refillStock(refilProductDTO.getProductId(), refilProductDTO.getQuantity());
        APIResponse apiResponse = new APIResponse(productResDto);
        return ResponseEntity.ok(apiResponse);
    }
}