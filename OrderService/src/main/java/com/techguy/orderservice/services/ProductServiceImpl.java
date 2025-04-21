package com.techguy.orderservice.services;

import com.techguy.orderservice.dto.ProductDTO;
import com.techguy.orderservice.entity.Category;
import com.techguy.orderservice.entity.Product;
import com.techguy.orderservice.repository.CategoryRepo;
import com.techguy.orderservice.repository.ProductRepo;
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
    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = modelMapper.map(productDTO, Product.class);
        product.setCreatedAt(LocalDateTime.now());
        product.setCategory(category);
        product.setStockLastRefilled(LocalDateTime.now());
        product.setTotalStockOverLifeTime(productDTO.getCurrentStock());
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        modelMapper.map(productDTO, existingProduct);
        existingProduct.setCategory(category);

        Product updatedProduct = productRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    @Override
    public ProductDTO refillStock(long productId, double quantity)
    {
        Product product = productRepository.findById(productId).get();
        double updatedStock = product.getCurrentStock() + quantity;
        double totalRefilled = product.getTotalStockOverLifeTime() + quantity;

        product.setTotalStockOverLifeTime(totalRefilled);
        product.setCurrentStock(updatedStock);
        product.setStockLastRefilled(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        ProductDTO mappedData = modelMapper.map(savedProduct, ProductDTO.class);
        return mappedData;


    }
}