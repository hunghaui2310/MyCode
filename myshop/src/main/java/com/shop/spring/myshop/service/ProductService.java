package com.shop.spring.myshop.service;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.model.Product;

import java.util.List;

public interface ProductService {

    public List<ProductInfoDTO> showInfoProduct();

    public List<Product> getAll();
}
