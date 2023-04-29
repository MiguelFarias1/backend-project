package com.superior.dev.backend.resources;

import com.superior.dev.backend.entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @GetMapping()
    public ResponseEntity<List<Category>>  findAll()
    {
        Category category = new Category(1L, "Books");

        Category other = new Category(2L, "Electronics");

        return ResponseEntity.ok(Arrays.asList(category,other));
    }
}
