package com.techguy.orderservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CategoryDTO
{
    @NotNull(message = "Product name null")
    @NotBlank(message = "title is blank")
    private String name;
    @NotNull(message = "Product description null")
    @NotBlank(message = "Description is blank")
    private String description;


}