package com.example.Bookstore.service.impl;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // Constructor Injection
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Page<Book> getAllBooks(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book not found"));
    }

    @Override
    public Book updateBook(String id, Book book) {

        Book existing = getBookById(id);

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setGenre(book.getGenre());
        existing.setIsbn(book.getIsbn());
        existing.setPrice(book.getPrice());
        existing.setDescription(book.getDescription());
        existing.setStockQuantity(book.getStockQuantity());
        existing.setImageUrl(book.getImageUrl());

        return bookRepository.save(existing);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> searchByTitle(
            String title,
            int page,
            int size
    ) {
        return bookRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(page, size)
        );
    }

    @Override
    public Page<Book> searchByAuthor(
            String author,
            int page,
            int size
    ) {
        return bookRepository.findByAuthorContainingIgnoreCase(
                author,
                PageRequest.of(page, size)
        );
    }
}