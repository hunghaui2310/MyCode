package com.shop.spring.myshop.repo;

import com.shop.spring.myshop.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

}
