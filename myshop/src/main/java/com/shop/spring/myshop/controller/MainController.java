package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.dto.ProductSearchDTO;
import com.shop.spring.myshop.model.AppUser;
import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.service.CategoryService;
import com.shop.spring.myshop.service.ProductCustomService;
import com.shop.spring.myshop.service.ProductService;
import com.shop.spring.myshop.service.impl.AppUserServiceImpl;
import com.shop.spring.myshop.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCustomService productCustomService;

    @Autowired
    private AppUserServiceImpl appUserService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 12);
        Page<ProductInfoDTO> pages = productCustomService.getProHasImage(pageable);

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
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", total);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("listProduct", pages);
        model.addAttribute("users", appUserService.findAll());
        model.addAttribute("extra", extra);
        model.addAttribute("checkLast", checkLast);
        return "client/index";
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String search(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
                         @RequestParam(name = "search-text", defaultValue = "") String text) {
        Pageable pageable = PageRequest.of(page, 16);
 //       Page<Product> pages = productService.searchProduct(pageable,text);
        Page<ProductSearchDTO> pages = productCustomService.searchProductAndCate(pageable,text);
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
        String baseUrl = "/search?page=";
        String searchUrl = "&search-text=" + text;
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", total);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("listProduct", pages);
//        model.addAttribute("users", appUserService.findAll());
        model.addAttribute("extra", extra);
        model.addAttribute("searchUrl", searchUrl);
        model.addAttribute("checkLast", checkLast);
        model.addAttribute("searchText", text);
        return "client/search";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String message){
        if(error != null){
            model.addAttribute("error", "Your user name and password isinvalid!");
        }
        if(message != null){
            model.addAttribute("message", "You have been logged out successfully!");
        }
        return "client/login";
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
        return "client/403Page";
    }
}
