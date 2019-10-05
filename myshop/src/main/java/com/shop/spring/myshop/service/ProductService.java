package com.shop.spring.myshop.service;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Page<Product> searchProduct(Pageable pageable, String text);

    Optional<Product> getProId(Long productId);

    void deleteProduct(Long productId);

    Product getOneProduct(Long id);
}
