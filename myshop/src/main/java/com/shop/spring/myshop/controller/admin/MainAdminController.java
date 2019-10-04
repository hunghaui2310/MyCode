package com.shop.spring.myshop.controller.admin;

import com.shop.spring.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainAdminController {

    @Autowired
    ProductService productService;

    @RequestMapping("/admin/product")
    public String getProduct(Model model){
        model.addAttribute("listProduct", productService.getAll());
        return "admin/product_list";
    }
}
