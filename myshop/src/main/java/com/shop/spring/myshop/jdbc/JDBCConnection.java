package com.shop.spring.myshop.jdbc;

import com.shop.spring.myshop.model.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCConnection {

    private static Connection connection = null;

    public static Connection getJDBCConnection() {
        if(connection != null)
            return connection;
        else {
            try {
                Properties properties = new Properties();
                InputStream inputStream = JDBCConnection.class.getClassLoader().getResourceAsStream("/application.properties");
                properties.load(inputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("username");
                String password = properties.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
            } catch (ClassNotFoundException | SQLException | IOException ex ) {
                ex.printStackTrace();
            }
            return connection;
        }
    }

    public static ArrayList<Product> getAllProduct(){
        connection = JDBCConnection.getJDBCConnection();
        ArrayList<Product> lstProduct = new ArrayList<Product>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select p.product_id,p.product_name,p.price,p.des,p.create_date,p.num_like from Product p");
            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getLong("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getInt("price"));
                product.setDescription(rs.getString("des"));
                product.setCreateDate(rs.getString("create_date"));
                product.setNumLike(rs.getInt("num_like"));
                lstProduct.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lstProduct;
    }
}
