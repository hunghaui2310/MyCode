package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.service.CategoryService;
import com.shop.spring.myshop.service.ProductService;
import com.shop.spring.myshop.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("listCategory",categoryService.getList());
        model.addAttribute("listProduct",productService.getAll());
        return "client/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "client/register";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        return "client/forgot-password";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "client/login";
    }

    @GetMapping("/order")
    public String order(Model model){
        return "client/order";
    }

    @GetMapping("/about")
    public String about(Model model){
        return "client/about";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        return "client/contact";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if(principal != null) {
            User loginUser = (User) ((Authentication)principal).getPrincipal();
            String userInfor = WebUtils.toString(loginUser);
            model.addAttribute("userInfor", userInfor);
            String message = "Xin chào " + principal.getName() + ". Bạn không có quyền truy cập vào trang web này";
            model.addAttribute("message", message);
        }
        return "403Page";
    }
}
