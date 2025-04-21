package com.techguy.inventoryservice.services;


import com.techguy.inventoryservice.dto.CategoryReqDto;
import com.techguy.inventoryservice.dto.CategoryResDto;
import com.techguy.inventoryservice.entity.Category;
import com.techguy.inventoryservice.exception.NoDataFoundException;
import com.techguy.inventoryservice.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService
{

    private final CategoryRepo categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryResDto createCategory(CategoryReqDto categoryReqDto) {
        Category category = modelMapper.map(categoryReqDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryResDto.class);
    }

    @Override
    public CategoryResDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Category not found with id: " + id));
        return modelMapper.map(category, CategoryResDto.class);
    }

    @Override
    public List<CategoryResDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryResDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResDto updateCategory(Long id, CategoryReqDto categoryReqDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Category not found with id: " + id));

        // Mapping DTO properties to existing entity
        modelMapper.map(categoryReqDto, category);

        Category updatedCategory = categoryRepository.save(category);
        return modelMapper.map(updatedCategory, CategoryResDto.class);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Category not found with id: " + id));
        categoryRepository.delete(category);
    }
}