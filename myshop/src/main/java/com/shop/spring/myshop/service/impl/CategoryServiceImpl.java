package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.model.Category;
import com.shop.spring.myshop.repo.CategoryRepo;
import com.shop.spring.myshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getList() {
        return categoryRepo.findAll();
    }
}
