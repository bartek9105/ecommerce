package com.example.ecommerce.ProductCatalog.service;

import com.example.ecommerce.ProductCatalog.dao.BookDao;
import com.example.ecommerce.ProductCatalog.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book addBook(Book book) {
        return bookDao.save(book);
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookDao.findAll();
    }
}
