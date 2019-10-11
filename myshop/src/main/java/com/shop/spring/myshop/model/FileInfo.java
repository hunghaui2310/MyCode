package com.shop.spring.myshop.model;

import javax.persistence.*;

@Entity
@Table(name = "file_info",uniqueConstraints = { @UniqueConstraint(name = "FILE_INFO_FK", columnNames = "product_id") })
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "file_id", nullable = false)
    private Long fileId;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    @Column(name = "file_name")
    private String filename;
    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Column(name = "url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public FileInfo(String filename, String url) {
        this.filename = filename;
        this.url = url;
    }

}
