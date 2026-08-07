package com.ecommerece.ecommerce_backend.service;

import com.ecommerece.ecommerce_backend.dto.CategoryRequest;
import com.ecommerece.ecommerce_backend.entity.Category;
import com.ecommerece.ecommerce_backend.exception.DuplicateResourceException;
import com.ecommerece.ecommerce_backend.exception.ResourceNotFoundException;
import com.ecommerece.ecommerce_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;

    }
    public Category createCategory(CategoryRequest request){
        categoryRepository.findByName(request.getName())
                .ifPresent(category->{
                    throw new DuplicateResourceException("Category with name "+request.getName()+" already exists");
                });
        Category category=new Category();
        category.setName(request.getName());
        return categoryRepository.save(category);
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()->
                new ResourceNotFoundException("Category not found with id: "+id));
    }
    public Category updateCategory(long id ,CategoryRequest request) {
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Category not found with id: "+id));
        category.setName(request.getName());
        return categoryRepository.save(category);
    }
    public void deleteCategory(long id){
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->
        new ResourceNotFoundException("Category id "+id+"Not found"));
        categoryRepository.delete(category);
    }
}
