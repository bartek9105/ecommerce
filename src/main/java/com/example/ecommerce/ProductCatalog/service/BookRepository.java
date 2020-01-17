package com.example.ecommerce.ProductCatalog.service;

import com.example.ecommerce.ProductCatalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book WHERE b.published = 1")
    List<Book> findAllPublished();
}
