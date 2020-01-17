package com.example.ecommerce;

import com.example.ecommerce.ProductCatalog.model.Book;
import com.example.ecommerce.ProductCatalog.service.BookCatalogFacade;
import com.example.ecommerce.ProductCatalog.service.BookRepository;
import com.example.ecommerce.dto.BookData;
import com.example.ecommerce.exceptions.NoSuchBookException;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Builder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CatalogTest {
    private static final String BOOK_NAME = "book";
    private static final long NOT_EXISTING_ID = 123456L;

    @Autowired
    BookCatalogFacade bookCatalogFacade;

    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp(){
        bookRepository.deleteAll();
    }

    @Test
    public void exceptionWhenNotExistingProductIsLoaded(){
        assertThatThrownBy(() -> {
            bookCatalogFacade.load(NOT_EXISTING_ID);
        }).isInstanceOf(NoSuchBookException.class);
    }

    public void itAllowsLoadSingleBookData(){

    }

    private Book thereIsPublishedBook(){
        return Book.builder()
                .name(BOOK_NAME)
                .author("Kowalski")
                .price("50.50")
                .build();
    }
}
