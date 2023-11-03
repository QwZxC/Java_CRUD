package com.example.java_crud.service;
import com.example.java_crud.dto.ProductDto;
import com.example.java_crud.entity.Product;
import com.example.java_crud.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public List<ProductDto> getProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public ProductDto create(ProductDto dto){
        Product product = mapper.map(dto, Product.class);
        productRepository.save(product);
        return dto;
    }

    public List<ProductDto> getProductsByCategoryId(Long categoryId){
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public ProductDto update(ProductDto dto){
        Product product = mapper.map(dto, Product.class);
        productRepository.save(product);
        return dto;
    }

    public ProductDto getById(Long id){
        return mapper.map(productRepository.findById(id).orElseThrow(), ProductDto.class);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
