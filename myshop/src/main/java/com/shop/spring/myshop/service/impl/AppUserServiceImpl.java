package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.model.AppUser;
import com.shop.spring.myshop.repo.UserRepository;
import com.shop.spring.myshop.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<AppUser> searchUser(Pageable pageable, String text) {
        return userRepository.searchAppUser(pageable,"%"+text.trim()+"%");
    }

    @Override
    public AppUser getAppUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void saveUser(AppUser appUser) {
        userRepository.save(appUser);
    }

    @Override
    public AppUser getOneUser(Long userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public AppUser updateUser(String userName, Long phoneNumber, String email, String address, String encrytedPassword, Long userId) {
        return userRepository.updateUser(userName,phoneNumber,email,address,encrytedPassword,userId);
    }

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

}
