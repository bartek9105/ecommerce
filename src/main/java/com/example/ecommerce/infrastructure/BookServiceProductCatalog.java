package com.example.ecommerce.infrastructure;

import com.example.ecommerce.ProductCatalog.model.Book;
import com.example.ecommerce.ProductCatalog.service.BookService;
import com.example.ecommerce.sales.products.Product;
import com.example.ecommerce.sales.products.ProductCatalog;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceProductCatalog implements ProductCatalog {
    private BookService bookService;

    public BookServiceProductCatalog(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Optional<Book> load(String productId) {
        return bookService.getAllBooks().stream()
                .filter(product -> product.getBookId().equals(productId))
                .findFirst();
    }
}
