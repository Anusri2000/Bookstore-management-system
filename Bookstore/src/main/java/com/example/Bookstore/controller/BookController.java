package com.example.Bookstore.controller;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Constructor Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public Page<Book> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return bookService.getAllBooks(page, size);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable String id,
            @RequestBody Book book
    ) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {

        bookService.deleteBook(id);

        return "Book Deleted Successfully";
    }

    @GetMapping("/search/title")
    public Page<Book> searchByTitle(
            @RequestParam String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {

        return bookService.searchByTitle(
                title,
                page,
                size
        );
    }

    @GetMapping("/search/author")
    public Page<Book> searchByAuthor(
            @RequestParam String author,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {

        return bookService.searchByAuthor(
                author,
                page,
                size
        );
    }
}