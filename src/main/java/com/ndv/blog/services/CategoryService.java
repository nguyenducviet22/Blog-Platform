package com.ndv.blog.services;

import com.ndv.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
