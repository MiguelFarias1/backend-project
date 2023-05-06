package com.superior.dev.backend.services;

import com.superior.dev.backend.dto.CategoryDTO;
import com.superior.dev.backend.entities.Category;
import com.superior.dev.backend.repositories.CategoryRepository;
import com.superior.dev.backend.services.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {

        List<Category> list = repository.findAll();

        return list.stream().map(CategoryDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {

        Optional<Category> element = repository.findById(id);

        return element.map(CategoryDTO::new).orElseThrow(
                () -> new CategoryNotFoundException("Categoria não encontrada !")
        );
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO category) {
        Category element = new Category();

        element.setName(category.getName());

        element = repository.save(element);

        return new CategoryDTO(element);
    }
}
