package com.shop.spring.myshop.controller.admin;

import com.shop.spring.myshop.model.AppUser;
import com.shop.spring.myshop.service.impl.AppUserServiceImpl;
import com.shop.spring.myshop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppUserController {

    @Autowired
    private AppUserServiceImpl appUserService;

    @RequestMapping(value = {"/getAllUser"}, method = RequestMethod.GET)
    public String getAllUser(Model model,
                             @RequestParam(name = "page", defaultValue = "0") Integer page,
                             @RequestParam(name = "search-text", defaultValue = "") String text){
        Pageable pageable = PageRequest.of(page, 10);
        Page<AppUser> pages = appUserService.searchUser(pageable,text);
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
        String baseUrl = "/getAllUser?page=";
        String searchUrl = "&search-text="+text;
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", total);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("listUser", pages);
        model.addAttribute("extra", extra);
        model.addAttribute("checkLast", checkLast);
        model.addAttribute("searchUrl", searchUrl);
        model.addAttribute("searchText", text);

        return "admin/basic_table";
    }
}
