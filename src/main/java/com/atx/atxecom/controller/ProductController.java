package com.atx.atxecom.controller;

import com.atx.atxecom.apiResponse.APIResponse;
import com.atx.atxecom.dto.ProductDTO;

import com.atx.atxecom.dto.RefilProductDTO;
import com.atx.atxecom.services.ProductService;
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
    public ResponseEntity<APIResponse> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        APIResponse apiResponse = new APIResponse(createdProduct);
        return ResponseEntity.ok(apiResponse);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getProductById(@PathVariable Long id) {
        ProductDTO productDTO = productService.getProductById(id);
        APIResponse apiResponse = new APIResponse(productDTO);
        return ResponseEntity.ok(apiResponse);
    }

    // Get all products
    @GetMapping
    public ResponseEntity<APIResponse> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        APIResponse apiResponse = new APIResponse(products);
        return ResponseEntity.ok(apiResponse);
    }

    // Update product
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
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

    @PutMapping
    public ResponseEntity<APIResponse> refillStock(@RequestBody RefilProductDTO refilProductDTO)
    {
        ProductDTO productDTO =
                productService.refillStock(refilProductDTO.getProductId(), refilProductDTO.getQuantity());
        APIResponse apiResponse = new APIResponse(productDTO);
        return ResponseEntity.ok(apiResponse);
    }
}