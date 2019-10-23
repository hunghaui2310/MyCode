package com.shop.spring.myshop.repo;

import com.shop.spring.myshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query(CustomQuery.SEARCH_PRODUCT)
    Page<Product> searchProduct(Pageable pageable, @Param("text") String text);

    @Query(CustomQuery.GET_PRODUCT)
    Product getByProductId(@Param("productId") Long productId);

    @Query(CustomQuery.SEARCH_PRODUCT_AND_CATE)
    List<Object[]> searchProAndCate(@Param("text") String text);

    @Transactional
    @Modifying
    @Query(value = "select p.product_id,p.product_name,p.price,p.discount,p.num_like,f.url from product p inner join file_inFo f on p.product_id = f.product_id", nativeQuery = true)
    List<Object[]> getProductHasImage();
}
