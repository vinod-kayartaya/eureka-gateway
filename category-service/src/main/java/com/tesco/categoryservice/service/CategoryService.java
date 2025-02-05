package com.tesco.categoryservice.service;

import com.tesco.categoryservice.dto.CategoryDTO;
import com.tesco.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    public List<CategoryDTO> getAllCategories(){
        return repo.findAll().stream().map(CategoryDTO::toCategoryDTO).toList();
    }

    public CategoryDTO getCategory(Integer id){
        var category = repo.findById(id).orElse(null);
        return CategoryDTO.toCategoryDTO(category);
    }
}
