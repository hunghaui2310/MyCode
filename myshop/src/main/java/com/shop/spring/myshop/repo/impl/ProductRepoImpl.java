package com.shop.spring.myshop.repo.impl;

import com.shop.spring.myshop.dto.ProductInfoDTO;
import com.shop.spring.myshop.jdbc.JDBCConnection;
import com.shop.spring.myshop.repo.ProductRepoCustom;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepoImpl extends JDBCConnection implements ProductRepoCustom {

    @Override
    public List<ProductInfoDTO> showProduct() {
        List<ProductInfoDTO> lstProduct = new ArrayList<>();
        try {
            Connection connection = getJDBCConnection();
            PreparedStatement pre = connection.prepareStatement("select p.product_id,p.product_name,p.price,p.image from product p, category c\n" +
                    "where p.category_id = c.category_id\n" +
                    "and p.category_id = ?");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ProductInfoDTO product1 = new ProductInfoDTO();
                product1.setProductId(rs.getLong("product_id"));
                product1.setName(rs.getString("product_name"));
                product1.setPrice(rs.getDouble("price"));
                product1.setImage(rs.getBytes("image"));
                lstProduct.add(product1);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
