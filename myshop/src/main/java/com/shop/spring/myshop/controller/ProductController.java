package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value={"/showProduct","/showProduct/{id}"}, method = RequestMethod.GET)
    public String showProduct(@PathVariable("id") Long productId, Model model){
//        Optional<Product> product = productService.getProId(productId);
//        model.addAttribute("products",product);
        return "client/single";
    }

}
