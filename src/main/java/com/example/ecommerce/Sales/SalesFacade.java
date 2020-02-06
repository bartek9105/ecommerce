package com.example.ecommerce.Sales;

import com.example.ecommerce.Sales.basket.Basket;
import com.example.ecommerce.Sales.basket.BasketStorage;
import com.example.ecommerce.Sales.exceptions.NoSuchProductException;
import com.example.ecommerce.Sales.products.Product;
import com.example.ecommerce.Sales.products.ProductCatalog;

public class SalesFacade {

    private SystemUserContext systemUserContext;
    private BasketStorage basketStorage;
    private ProductCatalog productCatalog;

    public SalesFacade(SystemUserContext systemUserContext, BasketStorage basketStorage, ProductCatalog productCatalog) {
        this.systemUserContext = systemUserContext;
        this.basketStorage = basketStorage;
        this.productCatalog = productCatalog;
    }

    public void addToBasket(Long productId){
        String currentClientId = systemUserContext.getCurrentUserId();

        Basket basket = basketStorage.loadForUser(currentClientId).orElse(
                Basket.empty()
        );
        Product product = productCatalog.load(productId)
                .orElseThrow(() -> new NoSuchProductException());

        basket.addProduct(product);

        basketStorage.save(basket);
    }

    public Basket getBasket(){
        String currentClientId = systemUserContext.getCurrentUserId();

        Basket basket = basketStorage.loadForUser(currentClientId)
                .orElse(Basket.empty());

        return basket;
    }
}
