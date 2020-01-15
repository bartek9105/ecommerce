package com.example.ecommerce.ProductCatalog.dao;

import com.example.ecommerce.ProductCatalog.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

}
