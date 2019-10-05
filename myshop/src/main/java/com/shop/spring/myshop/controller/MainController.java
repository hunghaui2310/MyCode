package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.service.CategoryService;
import com.shop.spring.myshop.service.ProductService;
import com.shop.spring.myshop.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model,
                           @RequestParam(name = "page", defaultValue = "0") Integer page,
                           @RequestParam(name = "search-text", defaultValue = "") String text) {
        Pageable pageable = PageRequest.of(page, 12);
        Page<Product> pages = productService.searchProduct(pageable, text);
        int current = pages.getNumber() + 1;
        long total = pages.getTotalPages();
        long totalElement = pages.getTotalElements();
        long begin = 1;
        long end = 1;
        if (current > 5 && total > 6) {
            begin = Math.max(1, current);
        }
        if (total != 0) {
            end = Math.min(begin + 4, total);
        }
        if (current == total - 5) {
            end = total;
        }
        boolean extra = false;
        boolean checkLast = false;
        if (total > 5 && current < total - 5) {
            extra = true;
        }
        if (total > 6 && current < total - 5) {
            checkLast = true;
        }
        String baseUrl = "/?page=";
        String searchUrl = "&search-text="+text;
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", total);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("listProduct", pages);
        model.addAttribute("extra", extra);
        model.addAttribute("checkLast", checkLast);
        model.addAttribute("searchUrl", searchUrl);
        model.addAttribute("searchText", text);
        model.addAttribute("listCategory",categoryService.getList());
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
