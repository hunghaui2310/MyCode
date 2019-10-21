package com.shop.spring.myshop.repo;

import com.shop.spring.myshop.model.Category;
import com.shop.spring.myshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(CustomQuery.GET_PRODUCT_BY_CATE)
    public List<Product> getProbyCate(@Param("categoryId") Long categoryId);

    @Transactional
    @Modifying
    @Query(CustomQuery.UPDATE_CATEGORY)
    void updateCategory(@Param("categoryName") String categoryName, @Param("categoryId") Long categoryId);
}
