package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.model.AppUser;
import com.shop.spring.myshop.repo.UserRepository;
import com.shop.spring.myshop.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<AppUser> searchUser(Pageable pageable, String text) {
        return userRepository.searchAppUser(pageable,"%"+text.trim()+"%");
    }
}
