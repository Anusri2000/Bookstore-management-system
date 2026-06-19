package com.example.Bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {

    @Id
    private String id;

    private String title;
    private String author;
    private String genre;
    private String isbn;
    private Double price;
    private String description;
    private Integer stockQuantity;
    private String imageUrl;

    // Constructors
    public Book() {
    }

    public Book(String id, String title, String author, String genre,
                String isbn, Double price, String description,
                Integer stockQuantity, String imageUrl) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}