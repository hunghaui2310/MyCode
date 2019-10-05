package com.shop.spring.myshop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "customer_address", nullable = false)
    private double customAddress;

    @Column(name = "customer_name", nullable = false)
    private String customName;

    @Column(name = "customer_phone", nullable = false)
    private String customPhone;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "order_num", nullable = false)
    private int orderNum;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCustomAddress() {
        return customAddress;
    }

    public void setCustomAddress(double customAddress) {
        this.customAddress = customAddress;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCustomPhone() {
        return customPhone;
    }

    public void setCustomPhone(String customPhone) {
        this.customPhone = customPhone;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
