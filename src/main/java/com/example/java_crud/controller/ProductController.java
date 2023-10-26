package com.example.java_crud.controller;

import com.example.java_crud.dto.ProductDTO;
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
    public ResponseEntity<List<ProductDTO>> get(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.create(dto));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.update(dto));
    }

    @DeleteMapping("/{productId}")
    public HttpStatus delete(@PathVariable Long productId){
        productService.delete(productId);
        return HttpStatus.OK;
    }
}
