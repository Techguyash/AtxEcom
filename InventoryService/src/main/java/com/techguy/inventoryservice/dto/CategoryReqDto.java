package com.techguy.inventoryservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CategoryReqDto
{

    @NotNull(message = "Product name null")
    @NotBlank(message = "title is blank")
    private String name;
    @NotNull(message = "Product description null")
    @NotBlank(message = "Description is blank")
    private String description;


}