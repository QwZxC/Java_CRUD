package com.example.java_crud.service;

import com.example.java_crud.dto.CategoryDto;
import com.example.java_crud.entity.Category;
import com.example.java_crud.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper mapper;

    public List<CategoryDto> getCategories(){
        return repository.findAll()
                .stream()
                .map(category -> mapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    public CategoryDto createCategory(CategoryDto dto){
        Category category = mapper.map(dto, Category.class);
        repository.save(category);
        dto.setId(category.getId());
        return dto;
    }
}
