package com.shop.spring.myshop.service;

import com.shop.spring.myshop.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppUserService {

    Page<AppUser> searchUser(Pageable pageable, String text);

    AppUser getAppUser(Long userId);

    void saveUser(AppUser appUser);

    AppUser getOneUser(Long userId);

    AppUser updateUser(String userName, Long phoneNumber, String email, String address, String encrytedPassword, Long userId);

    List<AppUser> findAll();
}
