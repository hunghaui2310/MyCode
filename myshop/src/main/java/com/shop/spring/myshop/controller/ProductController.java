package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/showProduct"}, method = RequestMethod.GET)
    public String showProduct(@RequestParam(name = "productId", defaultValue = "1") Long productId, Model model){
        model.addAttribute("products", productService.getProId(productId));
        return "client/single";
    }
}
