package com.example.java_crud.controller;

import com.example.java_crud.dto.ProductDto;
import com.example.java_crud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> get(@RequestParam(required = false, defaultValue = "0") Long categoryId){
        if (categoryId > 0){
            return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId));
        }
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto){
        return ResponseEntity.ok(productService.create(dto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto){
        return ResponseEntity.ok(productService.update(dto));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getById(productId));
    }

    @DeleteMapping("/{productId}")
    public HttpStatus delete(@PathVariable Long productId){
        productService.delete(productId);
        return HttpStatus.OK;
    }
}
