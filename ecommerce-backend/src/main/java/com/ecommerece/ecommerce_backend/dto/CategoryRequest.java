package com.ecommerece.ecommerce_backend.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequest{
    @NotBlank(message="category name is required")
    private String name;
    public CategoryRequest(){

    }
    public CategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
