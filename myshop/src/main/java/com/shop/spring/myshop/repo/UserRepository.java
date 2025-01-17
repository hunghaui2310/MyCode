package com.shop.spring.myshop.repo;

import com.shop.spring.myshop.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{

    @Query("select usr from AppUser usr where usr.userName = :userName")
    AppUser findUserName(@Param("userName") String userName);

    @Query(CustomQuery.SEARCH_USER)
    Page<AppUser> searchAppUser (Pageable pageable, @Param("text") String text);

    @Query(CustomQuery.UPDATE_USER)
    AppUser updateUser(@Param("userName") String userName,
                       @Param("phoneNumber") Long phoneNumber,
                       @Param("email") String email,
                       @Param("address") String address,
                       @Param("encrytedPassword") String encrytedPassword,
                       @Param("userId") Long userId);

    @Modifying
    @Query("update AppUser u set u.encrytedPassword = :password where u.userId = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);

    AppUser findByEmail(String email);

}
