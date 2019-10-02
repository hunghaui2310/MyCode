package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.repo.ProductRepoCustom;
import com.shop.spring.myshop.repo.impl.ProductRepo;
import com.shop.spring.myshop.repo.impl.ProductRepoImpl;
import com.shop.spring.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepoImpl productRepoCustom;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductInfoDTO> showInfoProduct() {
        return productRepoCustom.showProduct();
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }
}
