package com.shop.spring.myshop.repo;

public interface CustomQuery {

    String SEARCH_PRODUCT = "SELECT p FROM Product p WHERE p.productName like :text or p.price like :text or p.description like :text or p.createDate like :text or p.category like :text or p.numLike like :text";

    String GET_PRODUCT = "SELECT p FROM Product p WHERE p.productId = :productId";
}
