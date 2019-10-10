package com.shop.spring.myshop.service;

import com.shop.spring.myshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Page<Product> searchProduct(Pageable pageable, String text);

    Product findById(Long productId);

    void deleteProduct(Long productId);

    Product getOneProduct(Long id);

    Product getProductByQuery(Long productId);

    void save(Product product);
}
