package com.shop.spring.myshop.dto;

import java.math.BigInteger;

public class ProductInfoDTO {

    private BigInteger productId;
    private String productName;
    private int price;
    private String discount;
    private int numLike;
    private byte[] url;

    public ProductInfoDTO() {
    }

    public ProductInfoDTO(Object[] item){
        this.productId = (BigInteger) item[0];
        this.productName = String.valueOf(item[1]);
        this.price = (int) item[2];
        this.discount = String.valueOf(item[3]);
        this.numLike = (int) item[4];
        this.url = (byte[]) item[5];
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
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

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
