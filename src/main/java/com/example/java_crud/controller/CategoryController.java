package com.example.java_crud.controller;

import com.example.java_crud.dto.CategoryDto;
import com.example.java_crud.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false, defaultValue = "") String name){
        name = name.trim();
        if (!name.isEmpty()){
            return ResponseEntity.ok(service.getCategoryByName(name));
        }
            return ResponseEntity.ok(service.getCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto){
        return ResponseEntity.ok(service.createCategory(dto));
    }
}
