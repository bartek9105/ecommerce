package com.example.ecommerce.controller;

import com.example.ecommerce.model.Book;
import com.example.ecommerce.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value="/add")
    public Book createBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping(value="/all")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

}
