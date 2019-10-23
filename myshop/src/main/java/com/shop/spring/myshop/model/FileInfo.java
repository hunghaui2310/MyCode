package com.shop.spring.myshop.model;

import org.springframework.web.multipart.MultipartFile;

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
    private String extraField;

    public String getExtraField() {
        return extraField;
    }

    public void setExtraField(String extraField) {
        this.extraField = extraField;
    }

    @Lob
    @Column(name = "url", length = Integer.MAX_VALUE, nullable = true)
    private byte[] url;

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
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

}
