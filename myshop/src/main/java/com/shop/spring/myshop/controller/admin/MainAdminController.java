package com.shop.spring.myshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainAdminController {

    @RequestMapping("/admin/product")
    public String getProduct(Model model){
        return "admin/product_list";
    }
}
