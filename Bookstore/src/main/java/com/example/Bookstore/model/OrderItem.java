package com.example.Bookstore.model;

public class OrderItem {

    private String bookId;

    private Integer quantity;

    private Double price;

    // Default Constructor
    public OrderItem() {
    }

    // Parameterized Constructor
    public OrderItem(String bookId, Integer quantity, Double price) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getBookId() {
        return bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    // Setters
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}