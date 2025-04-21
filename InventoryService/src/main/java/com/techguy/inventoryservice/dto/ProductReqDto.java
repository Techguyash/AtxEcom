package com.techguy.inventoryservice.dto;

import lombok.Data;

@Data
public class ProductReqDto
{
    private String name;
    private String description;
    private Long categoryId;
    private String imageUrl;
    private double salesPrice;
    private double regularPrice;
    private double rating;
    private double currentStock;
    private String brandName;
    private boolean featuredProduct;
    private boolean isPublished;
}