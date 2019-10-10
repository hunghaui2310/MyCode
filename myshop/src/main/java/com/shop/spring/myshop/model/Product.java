package com.shop.spring.myshop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product",uniqueConstraints = { @UniqueConstraint(name = "USER_ROLE_PK", columnNames = "category_id") })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "des")
    private String description;

    @Lob
    @Column(name = "image",length = Integer.MAX_VALUE)
    private byte[] image;

    @Column(name = "num_like")
    private Long numLike;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Column(name = "create_date", nullable = false)
    private String createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumLike() {
        return numLike;
    }

    public void setNumLike(Long numLike) {
        this.numLike = numLike;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Product() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String productName, int price, String description, byte[] image, Long numLike, String createDate, Category category) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
        this.numLike = numLike;
        this.createDate = createDate;
        this.category = category;
    }
}
