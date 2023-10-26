package com.example.java_crud.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private Short amount;
    private CategoryDto category;

}
