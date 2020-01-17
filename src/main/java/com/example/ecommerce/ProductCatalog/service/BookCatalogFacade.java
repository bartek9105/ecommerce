package com.example.ecommerce.ProductCatalog.service;

import com.example.ecommerce.ProductCatalog.model.Book;
import com.example.ecommerce.dto.BookData;
import com.example.ecommerce.exceptions.NoSuchBookException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class BookCatalogFacade {
    BookRepository bookRepository;

    public BookCatalogFacade(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Long create(Book book) {
        bookRepository.save(book);

        return book.getBookId();
    }

    public List<Book> all(){
        return bookRepository.findAll();
    }

    public List<Book> allPublished(){
        return bookRepository.findAllPublished();
    }

    public BookData load(Long id){
        BookData book = bookRepository.findById(id)
                .map(Book::toData)
                .orElseThrow(NoSuchBookException::new);

        return book;
    }
}
