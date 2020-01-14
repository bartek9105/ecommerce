package com.example.ecommerce.controller;

import com.example.ecommerce.model.Book;
import com.example.ecommerce.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value="/add")
    public Book createTicket(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping(value="/book/{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") Integer bookId){
        return bookService.getBookById(bookId);
    }
}
