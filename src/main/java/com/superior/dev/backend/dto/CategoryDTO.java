package com.superior.dev.backend.dto;

import com.superior.dev.backend.entities.Category;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
