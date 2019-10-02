package com.shop.spring.myshop.repo.impl;

import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.repo.ProductRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>, ProductRepoCustom {

}
