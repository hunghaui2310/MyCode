package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.dto.UserRegisterDTO;
import com.shop.spring.myshop.model.AppRole;
import com.shop.spring.myshop.model.AppUser;
import com.shop.spring.myshop.model.UserRole;
import com.shop.spring.myshop.repo.UserRepository;
import com.shop.spring.myshop.service.UserRoleService;
import com.shop.spring.myshop.service.impl.AppRoleServiceImpl;
import com.shop.spring.myshop.service.impl.UserRoleServiceImpl;
import com.shop.spring.myshop.utils.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppRoleServiceImpl roleService;

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @ModelAttribute("user")
    public UserRegisterDTO userRegistrationDto() {
        return new UserRegisterDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "client/register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegisterDTO userDto, BindingResult result){

        AppUser existing = userRepository.findUserName(userDto.getUserName());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "client/register";
        }
        AppUser temp = new AppUser();
        temp.setUserName(userDto.getUserName());
        temp.setEncrytedPassword(EncrytedPasswordUtils.encrytedPassword(userDto.getPassword()));
        temp.setEnabled(true);
        userRepository.save(temp);
        AppUser tempUser = userRepository.findUserName(userDto.getUserName());
        // Đăng ký mới mặc định là role user.
        AppRole tempRole = roleService.getRole(2L); // Mặc định là user.
        userRoleService.saveUserRole(new UserRole(tempUser, tempRole));

        return "redirect:/login";
    }



}
