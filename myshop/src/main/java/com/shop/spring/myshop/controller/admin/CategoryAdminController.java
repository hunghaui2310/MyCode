package com.shop.spring.myshop.controller.admin;

import com.shop.spring.myshop.model.Category;
import com.shop.spring.myshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class CategoryAdminController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String showAdminCate(Model model){
        model.addAttribute("listCategory",categoryService.getList());
        return "admin/category";
    }

    @GetMapping("/find-category")
    @ResponseBody
    public Category getOneCate(Long categoryId){
        return categoryService.getOne(categoryId);
    }

    @PostMapping("/update-category")
    public String updateCate(@RequestParam("categoryName") String categoryName,
                             @RequestParam("categoryId") Long categoryId){
        categoryService.updateCategory(categoryName, categoryId);
        return "redirect:/admin/category";
    }
}
