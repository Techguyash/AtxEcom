package com.techguy.inventoryservice.dto;

import lombok.Data;

@Data
public class ProductResDto
{
    private Long productId;
    private String name;
    private String description;
    private Long categoryId;
    private Long vendorId;
    private String imageUrl;
    private double salesPrice;
    private double regularPrice;
    private double rating;
    private double currentStock;
    private String brandName;
    private boolean featuredProduct;
    private boolean isPublished;
}