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
    private ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Page<Product> searchProduct(Pageable pageable, String text) {
        return productRepo.searchProduct(pageable, "%"+text.trim()+"%");
    }

    @Override
    public Product findById(Long productId) {
        return productRepo.findById(productId).get();
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public Product getOneProduct(Long id) {
        return productRepo.getOne(id);
    }

    @Override
    public Product getProductByQuery(Long productId) {
        return productRepo.getByProductId(productId);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }


}
