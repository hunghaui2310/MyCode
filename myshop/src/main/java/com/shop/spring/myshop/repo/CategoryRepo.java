package com.shop.spring.myshop.repo;

import com.shop.spring.myshop.model.Category;
import com.shop.spring.myshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(CustomQuery.GET_PRODUCT_BY_CATE)
    public List<Product> getProbyCate(@Param("categoryId") Long categoryId);
}
