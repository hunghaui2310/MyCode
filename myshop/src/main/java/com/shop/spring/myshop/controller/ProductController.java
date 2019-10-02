package com.shop.spring.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/showProduct")
    public String showProduct(Model model){
        return "admin/product";
    }
}
