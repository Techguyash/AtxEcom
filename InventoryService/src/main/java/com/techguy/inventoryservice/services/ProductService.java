package com.techguy.inventoryservice.services;


import com.techguy.inventoryservice.dto.ProductReqDto;
import com.techguy.inventoryservice.dto.ProductResDto;

import java.util.List;

public interface ProductService {
    ProductResDto createProduct(ProductReqDto productResDto);
    ProductResDto getProductById(Long id);
    List<ProductResDto> getAllProducts();
    ProductResDto updateProduct(Long id, ProductReqDto productResDto);
    void deleteProduct(Long id);
    ProductResDto refillStock(long productId, double quantity);

}