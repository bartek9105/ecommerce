package com.example.ecommerce.sales.offer;

import com.example.ecommerce.ProductCatalog.model.Book;
import com.example.ecommerce.ProductCatalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offer")
public class OfferController {
    @Autowired
    private OfferMaker offerMaker;

}