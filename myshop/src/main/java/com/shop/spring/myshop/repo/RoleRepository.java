package com.shop.spring.myshop.repo;

import com.shop.spring.myshop.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {

    @Query("select ur.appRole.roleName from UserRole ur where ur.appUser.userId = :userId")
    public List<String> getRoleNames(@Param("userId") Long userId);
}
