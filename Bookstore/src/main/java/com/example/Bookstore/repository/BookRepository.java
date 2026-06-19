package com.example.Bookstore.repository;

import com.example.Bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

    Page<Book> findByTitleContainingIgnoreCase(
            String title,
            Pageable pageable
    );

    Page<Book> findByAuthorContainingIgnoreCase(
            String author,
            Pageable pageable
    );
}