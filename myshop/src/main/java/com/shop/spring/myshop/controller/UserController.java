package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.model.AppUser;
import com.shop.spring.myshop.service.impl.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private AppUserServiceImpl appUserService;

    @RequestMapping(value = {"/myAccount/{id}"})
    public ModelAndView getAccount(@PathVariable("id") Long userId){
        ModelAndView view = new ModelAndView("client/view_user");
        AppUser appUser = appUserService.getAppUser(userId);
        view.addObject("users",appUser);
        return view;
    }

}
