package com.shop.spring.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public String showCart(Model model){
        return "client/cart";
    }
}
