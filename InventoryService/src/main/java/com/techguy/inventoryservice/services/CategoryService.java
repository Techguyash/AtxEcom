package com.techguy.inventoryservice.services;


import com.techguy.inventoryservice.dto.CategoryReqDto;
import com.techguy.inventoryservice.dto.CategoryResDto;

import java.util.List;

public interface CategoryService {
    CategoryResDto createCategory(CategoryReqDto categoryReqDto);
    CategoryResDto getCategoryById(Long id);
    List<CategoryResDto> getAllCategories();
    CategoryResDto updateCategory(Long id, CategoryReqDto categoryReqDto);
    void deleteCategory(Long id);
}