package com.shop.spring.myshop.service;

import com.shop.spring.myshop.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AppUserService {

    Page<AppUser> searchUser(Pageable pageable, String text);
}
