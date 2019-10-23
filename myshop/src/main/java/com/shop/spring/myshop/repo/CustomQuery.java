package com.shop.spring.myshop.repo;

public interface CustomQuery {

    String SEARCH_PRODUCT = "SELECT p FROM Product p WHERE p.productName like :text or p.price like :text or p.description like :text or p.createDate like :text or p.category like :text or p.numLike like :text";

    String SEARCH_PRODUCT_AND_CATE = "select p.productId,p.productName,p.price,p.numLike,p.discount,c.categoryName " +
            "from Product p join p.category c where p.productName like :text or p.price like :text or p.description like :text or c.categoryName like :text";

    String SEARCH_USER = "SELECT u FROM AppUser u WHERE u.userName like :text or u.phoneNumber like :text or u.email like :text or u.address like :text";

    String GET_PRODUCT = "SELECT p FROM Product p WHERE p.productId = :productId";

    String UPDATE_USER = "update AppUser set userName = :userName, phoneNumber = :phoneNumber, email = :email, address = :address, encrytedPassword = :encrytedPassword where userId = :userId";

    String GET_PRODUCT_BY_CATE = "select p from Product p, Category c where categoryId = :categoryId";

    String UPDATE_CATEGORY = "update Category set categoryName = :categoryName where categoryId = :categoryId";

    String GET_PRODUCT_IMAGE = "select p.productId,p.productName,p.price,p.discount,p.numLike,f.url from Product p inner join FileInFo f on p.productId = f.product";
}
