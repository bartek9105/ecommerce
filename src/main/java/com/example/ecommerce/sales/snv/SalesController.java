package com.example.ecommerce.sales.snv;

import com.example.ecommerce.sales.basket.Basket;
import com.example.ecommerce.sales.exceptions.NoSuchProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basket")
public class SalesController {

    @Autowired
    private SalesFacade salesFacade;

    @PostMapping("/add-to-basket/{id}")
    public String addProductToBasket(@PathVariable(value="id") String productId){
        try{
            salesFacade.addToBasket(productId);
            return "added to basket";
        }catch (NoSuchProductException e){
            return "doesnt work";
        }
    }

    @GetMapping("/get-basket")
    public Basket getCart(){
        return salesFacade.getBasket();
    }

    @GetMapping("/clear-basket")
    public void clearBasket(){
        salesFacade.clearBasket();
    }

}
