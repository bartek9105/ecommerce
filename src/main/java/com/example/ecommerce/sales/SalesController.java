package com.example.ecommerce.sales;

import com.example.ecommerce.sales.exceptions.NoSuchProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired
    private SalesFacade salesFacade;

    @PostMapping("/add-to-basket/{id}")
    public String addProductToBasket(@PathVariable(value="id") Long productId){
        try{
            salesFacade.addToBasket(productId);
            return "it works";
        }catch (NoSuchProductException e){
            return "doesnt work";
        }
    }
}
