package com.example.java_crud.service;
import com.example.java_crud.dto.ProductDTO;
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

    public List<ProductDTO> getProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO create(ProductDTO dto){
        Product product = mapper.map(dto, Product.class);
        productRepository.save(product);
        return dto;
    }

    public ProductDTO update(ProductDTO dto){
        Product product = mapper.map(dto, Product.class);
        productRepository.save(product);
        return dto;
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
