package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.model.AppRole;
import com.shop.spring.myshop.repo.RoleRepository;
import com.shop.spring.myshop.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppRoleServiceImpl implements AppRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppRole getRole(Long id) {
        return roleRepository.findById(id).get();
    }
}
