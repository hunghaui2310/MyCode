package com.shop.spring.myshop.repo;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepo {

//    @Modifying
//    @Transactional
//    @Query(value = "SELECT p.product_id = :productId, p.product_name = :productName, p.price = :price, p.image = :image\n"
//    +"FROM product p, category c WHERE p.category_id = c.category_id AND p.category_id = 1", nativeQuery = true)
//    public void showInfoProduct(@Param("productId") Long productId,
//                                @Param("productName") String productName,
//                                @Param("price") double price,
//                                @Param("image") byte[] image);

    public List<ProductInfoDTO> showProduct();

}
