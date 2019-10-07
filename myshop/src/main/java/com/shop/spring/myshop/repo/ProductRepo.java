package com.shop.spring.myshop.repo;

import com.shop.spring.myshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query(CustomQuery.SEARCH_PRODUCT)
    Page<Product> searchProduct(Pageable pageable, @Param("text") String text);

    @Query(CustomQuery.GET_PRODUCT)
    Product getByProductId(@Param("productId") Long productId);

}
