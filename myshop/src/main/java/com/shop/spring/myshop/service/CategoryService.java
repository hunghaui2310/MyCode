package com.shop.spring.myshop.service;

import com.shop.spring.myshop.model.Category;
import com.shop.spring.myshop.model.Product;

import java.util.List;

public interface CategoryService {

    public List<Category> getList();

    List<Product> getProductbycate(Long categoryId);

    Category getOne(Long categoryId);

    void updateCategory(String categoryName, Long categoryId);
}
