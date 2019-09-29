package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.utils.WebUtils;
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

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "client/index";
    }

    @GetMapping("/register")
    public String login(Model model) {
        return "client/register";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        return "client/forgot-password";
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
