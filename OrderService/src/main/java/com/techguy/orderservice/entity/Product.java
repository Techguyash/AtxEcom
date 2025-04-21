package com.techguy.orderservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ashiq
 * @createdOn 02/03/25 12:47 pm
 * @project AtxEcom
 **/
@Entity
@Data
@NoArgsConstructor
@Schema(name = "Product", description = "Represents a product in the e-commerce system")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the product", example = "1")
    private Long productId;

    @Schema(description = "Name of the product", example = "Wireless Headphones")
    private String name;

    @Schema(description = "Detailed description of the product", example = "High-quality Bluetooth headphones with noise cancellation")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @Schema(description = "Category of the product")
    private Category category;

    @Schema(description = "URL of the product image", example = "https://example.com/images/product1.jpg")
    private String imageUrl;

    @Schema(description = "Current sales price of the product", example = "89.99")
    private double salesPrice;

    @Schema(description = "Regular price of the product before discounts", example = "99.99")
    private double regularPrice;

    @Schema(description = "Customer rating of the product", example = "4.5")
    private double rating;

    @Schema(description = "Current stock available", example = "150")
    private double currentStock;

    @Schema(description = "Brand name of the product", example = "Sony")
    private String brandName;

    @Schema(description = "Indicates if the product is featured", example = "true")
    private boolean featuredProduct;

    @Schema(description = "Indicates if the product is published", example = "true")
    private boolean isPublished;

    @Schema(description = "Timestamp when the product was added", example = "2024-03-02T12:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp of the last stock refill", example = "2024-02-20T08:30:00")
    private LocalDateTime stockLastRefilled;

    @Schema(description = "Total stock refilled until today", example = "150")
    private double totalStockOverLifeTime;


}
