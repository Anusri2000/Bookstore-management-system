package com.example.Bookstore.service;

import com.example.Bookstore.model.Book;
import org.springframework.data.domain.Page;

public interface BookService {

    Book addBook(Book book);

    Page<Book> getAllBooks(int page, int size);

    Book getBookById(String id);

    Book updateBook(String id, Book book);

    void deleteBook(String id);

    Page<Book> searchByTitle(
            String title,
            int page,
            int size
    );

    Page<Book> searchByAuthor(
            String author,
            int page,
            int size
    );
}