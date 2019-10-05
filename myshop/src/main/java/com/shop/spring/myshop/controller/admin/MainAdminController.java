package com.shop.spring.myshop.controller.admin;

import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainAdminController {

    @Autowired
    ProductService productService;

    @RequestMapping("/admin/product")
    public String getProduct(Model model,
                             @RequestParam(name = "page", defaultValue = "0") Integer page,
                             @RequestParam(name = "search-text", defaultValue = "") String text){
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
        String baseUrl = "/admin/product?page=";
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
        return "admin/product_list";
    }

    @GetMapping("/find-product")
    @ResponseBody
    public Product findProduct(Long id){
        return productService.getOneProduct(id);
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@RequestParam(name = "id") Long productId,
                                @RequestParam(name = "page") int page,
                                @RequestParam(name = "text") String text){
        productService.deleteProduct(productId);
        return "redirect:/admin/product?page=" + page + "&search-text=" + text;
    }
}
