package com.shop.spring.myshop.service;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.dto.ProductSearchDTO;
import com.shop.spring.myshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCustomService {

    List<Product> getProductById1();

    Page<ProductSearchDTO> searchProductAndCate(Pageable pageable, String text);

    Page<ProductInfoDTO> getProHasImage(Pageable pageable);
}
