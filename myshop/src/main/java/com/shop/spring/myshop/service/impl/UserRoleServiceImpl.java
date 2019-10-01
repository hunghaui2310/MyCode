package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.model.UserRole;
import com.shop.spring.myshop.repo.UserRoleRepo;
import com.shop.spring.myshop.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Override
    public void saveUserRole(UserRole userRole) {
        userRoleRepo.save(userRole);
    }
}
