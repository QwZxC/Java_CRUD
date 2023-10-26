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
    public ResponseEntity<List<ProductDto>> get(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId));
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto){
        return ResponseEntity.ok(productService.create(dto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto){
        return ResponseEntity.ok(productService.update(dto));
    }

    @DeleteMapping("/{productId}")
    public HttpStatus delete(@PathVariable Long productId){
        productService.delete(productId);
        return HttpStatus.OK;
    }
}
