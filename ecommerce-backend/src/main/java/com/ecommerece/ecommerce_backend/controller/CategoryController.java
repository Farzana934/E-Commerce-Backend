package com.ecommerece.ecommerce_backend.controller;

import com.ecommerece.ecommerce_backend.dto.CategoryRequest;
import com.ecommerece.ecommerce_backend.entity.Category;
import com.ecommerece.ecommerce_backend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryservice){
        this.categoryService=categoryservice;
    }
    @PostMapping
    public Category createCategory(@Valid @RequestBody CategoryRequest request){
        return categoryService.createCategory(request);
    }
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable long id,@Valid @RequestBody CategoryRequest request){
        return categoryService.updateCategory(id,request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
