package com.shop.spring.myshop.service.impl;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.dto.ProductSearchDTO;
import com.shop.spring.myshop.model.Product;
import com.shop.spring.myshop.repo.ProductRepo;
import com.shop.spring.myshop.service.ProductCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCustomServiceImpl implements ProductCustomService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProductById1() {
        return null;
    }

    @Override
    public Page<ProductSearchDTO> searchProductAndCate(Pageable pageable, String text) {
        List<Object[]> lstObj = productRepo.searchProAndCate("%"+text+"%");
        List<ProductSearchDTO> lstProduct = new ArrayList<>();
        for(Object[] data : lstObj){
            lstProduct.add(new ProductSearchDTO(data));
        }
        int start = (int)pageable.getOffset();
        int end = (int) ((pageable.getOffset() + pageable.getPageSize()) > lstProduct.size()?
                lstProduct.size():pageable.getOffset() + pageable.getPageSize());
        List<ProductSearchDTO> subList = lstProduct.subList(start, end);
        return new PageImpl<ProductSearchDTO>(subList, pageable, lstProduct.size());
    }

    @Override
    public Page<ProductInfoDTO> getProHasImage(Pageable pageable) {
        List<Object[] > lstObj = productRepo.getProductHasImage();
        List<ProductInfoDTO> lstProduct = new ArrayList<>();
        for(Object[] data : lstObj){
            lstProduct.add(new ProductInfoDTO(data));
        }
        int start = (int)pageable.getOffset();
        int end = (int) ((pageable.getOffset() + pageable.getPageSize()) > lstProduct.size()?
                lstProduct.size():pageable.getOffset() + pageable.getPageSize());
        List<ProductInfoDTO> subList = lstProduct.subList(start,end);
        return new PageImpl<>(subList, pageable, lstProduct.size());
    }
}
