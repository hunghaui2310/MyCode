package com.shop.spring.myshop.dto;

public class ProductSearchDTO {

    private Long productId;
    private String productName;
    private int price;
    private int numLike;
    private String discount;

    private String categoryName;

    public ProductSearchDTO(Object[] item){
        this.productId = (Long) item[0];
        this.productName = String.valueOf(item[1]);
        this.price = (int) item[2];
        this.numLike = (int) item[3];
        this.discount = String.valueOf(item[4]);
        this.categoryName = String.valueOf(item[5]);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
