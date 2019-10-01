package com.shop.spring.myshop.service;

import com.shop.spring.myshop.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    public List<Category> getList();
}
