package com.shop.spring.myshop.controller.admin;

import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductAdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/product-detail"} , method = RequestMethod.GET)
    public String getProduct(Model model, @RequestParam(name = "productId") Long productId) {
        model.addAttribute("product", productService.getProductByQuery(productId));
        return "admin/product_details";
    }

}
