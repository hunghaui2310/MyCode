package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.dto.UserRegisterDTO;
import com.shop.spring.myshop.model.AppUser;
import com.shop.spring.myshop.repo.RoleRepository;
import com.shop.spring.myshop.repo.UserRepository;
import com.shop.spring.myshop.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findUserName(username);
        if(appUser == null) {
            throw new UsernameNotFoundException("User "+ username + " not found!!!");
        }

        List<String> roleNames = roleRepository.getRoleNames(appUser.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(roleNames != null) {
            for(String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), appUser.getEncrytedPassword(), grantList);
        return userDetails;
    }

    public AppUser findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void updatePassword(String password, Long userId) {
        userRepository.updatePassword(password, userId);
    }

    public AppUser save(UserRegisterDTO registration){
        AppUser user = new AppUser();
        user.setUserName(registration.getUserName());
        user.setEncrytedPassword(passwordEncoder.encode(registration.getPassword()));
        return userRepository.save(user);
    }
}
