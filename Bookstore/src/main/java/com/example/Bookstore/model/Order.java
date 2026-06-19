package com.example.Bookstore.model;

import com.example.Bookstore.enums.OrderStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String customerName;
    private String customerEmail;
    private List<OrderItem> items;
    private Double totalPrice;
    private OrderStatus status;

    // Constructors
    public Order() {
    }

    public Order(String id, String customerName, String customerEmail,
                 List<OrderItem> items, Double totalPrice,
                 OrderStatus status) {

        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}