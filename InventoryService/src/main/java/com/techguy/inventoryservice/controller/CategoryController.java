package com.techguy.inventoryservice.controller;


import com.techguy.inventoryservice.dto.CategoryReqDto;
import com.techguy.inventoryservice.dto.CategoryResDto;
import com.techguy.inventoryservice.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // Create a new category
    @PostMapping
    public ResponseEntity<CategoryResDto> createCategory(@RequestBody CategoryReqDto categoryReqDto) {
        CategoryResDto createdCategory = categoryService.createCategory(categoryReqDto);
        return ResponseEntity.ok(createdCategory);
    }

    // Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResDto> getCategoryById(@PathVariable Long id) {
        CategoryResDto categoryReqDto = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryReqDto);
    }

    // Get all categories
    @GetMapping
    public ResponseEntity<List<CategoryResDto>> getAllCategories() {
        List<CategoryResDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Update category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResDto> updateCategory(@PathVariable Long id, @RequestBody CategoryReqDto categoryReqDto) {
        CategoryResDto updatedCategory = categoryService.updateCategory(id, categoryReqDto);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete category
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
}