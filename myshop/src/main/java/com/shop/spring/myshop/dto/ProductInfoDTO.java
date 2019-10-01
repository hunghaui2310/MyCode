package com.shop.spring.myshop.dto;

import com.shop.spring.myshop.model.Product;

public class ProductInfoDTO {

    private Long productId;
    private String name;
    private double price;
    private boolean newProduct = false;
    private byte[] image;
//    private CommonsMultipartFile fileData;

    public ProductInfoDTO() {
    }

    public ProductInfoDTO(Product product) {
        this.productId = product.getProductId();
        this.name = product.getProductName();
        this.price = product.getPrice();
    }

    public ProductInfoDTO(Long productId, String name, double price, byte[] image) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

//    public CommonsMultipartFile getFileData() {
//        return fileData;
//    }
//
//    public void setFileData(CommonsMultipartFile fileData) {
//        this.fileData = fileData;
//    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
