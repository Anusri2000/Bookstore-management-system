package com.example.Bookstore.dto;

public class OrderRequest {

    private String bookId;
    private Integer quantity;
    private String customerName;
    private String customerEmail;

    public OrderRequest() {
    }

    public String getBookId() {
        return bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}