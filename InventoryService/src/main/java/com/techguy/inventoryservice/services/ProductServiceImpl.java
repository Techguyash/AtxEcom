package com.techguy.inventoryservice.services;


import com.techguy.inventoryservice.dto.ProductReqDto;
import com.techguy.inventoryservice.dto.ProductResDto;
import com.techguy.inventoryservice.entity.Category;
import com.techguy.inventoryservice.entity.Product;
import com.techguy.inventoryservice.repository.CategoryRepo;
import com.techguy.inventoryservice.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService
{

    private final ProductRepo productRepository;
    private final CategoryRepo categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResDto createProduct(ProductReqDto productReqDto) {
        Category category = categoryRepository.findById(productReqDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = modelMapper.map(productReqDto, Product.class);
        product.setProductId(null);
        product.setCreatedAt(LocalDateTime.now());
        product.setCategory(category);
        product.setStockLastRefilled(LocalDateTime.now());
        product.setTotalStockOverLifeTime(productReqDto.getCurrentStock());
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResDto.class);
    }

    @Override
    public ProductResDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductResDto.class);
    }

    @Override
    public List<ProductResDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductResDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResDto updateProduct(Long id, ProductReqDto productResDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Category category = categoryRepository.findById(productResDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        modelMapper.map(productResDto, existingProduct);
        existingProduct.setCategory(category);

        Product updatedProduct = productRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, ProductResDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    @Override
    public ProductResDto refillStock(long productId, double quantity)
    {
        Product product = productRepository.findById(productId).get();
        double updatedStock = product.getCurrentStock() + quantity;
        double totalRefilled = product.getTotalStockOverLifeTime() + quantity;

        product.setTotalStockOverLifeTime(totalRefilled);
        product.setCurrentStock(updatedStock);
        product.setStockLastRefilled(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        ProductResDto mappedData = modelMapper.map(savedProduct, ProductResDto.class);
        return mappedData;


    }
}