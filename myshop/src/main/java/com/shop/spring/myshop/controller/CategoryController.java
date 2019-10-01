package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String showCategory(Model model){
        model.addAttribute("listCategory",categoryService.getList());
        return "client/index";
    }
}
