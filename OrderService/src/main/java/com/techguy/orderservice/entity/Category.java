package com.techguy.orderservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Schema(name = "Category", description = "Represents a product category")  // Explicit schema definition
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the category", example = "1")
    private Long categoryId;


    @Column(nullable = false, unique = true)
    @Schema(description = "Name of the category", example = "Electronics", requiredMode = Schema.RequiredMode.REQUIRED)
    private String categoryName;

    @Schema(description = "Description of the category", example = "All electronic items like mobiles, laptops, and accessories")
    private String categoryDescription;


    @Schema(description = "Indicates if the category is active", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean isActive=false;


}