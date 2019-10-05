package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.repo.ProductRepo;
import com.shop.spring.myshop.repo.impl.ProductRepoImpl;
import com.shop.spring.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Product getByProductId(Long productId) {
        return productRepo.getByProductId(productId);
    }

    @Override
    public Page<Product> searchProduct(Pageable pageable, String text) {
        return productRepo.searchProduct(pageable, "%"+text.trim()+"%");
    }

    @Override
    public Optional<Product> getProId(Long productId) {
        return productRepo.findById(productId);
    }

}
