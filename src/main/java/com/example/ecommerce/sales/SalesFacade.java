package com.example.ecommerce.sales;

import com.example.ecommerce.sales.basket.Basket;
import com.example.ecommerce.sales.basket.BasketStorage;
import com.example.ecommerce.sales.exceptions.NoSuchProductException;
import com.example.ecommerce.sales.products.Product;
import com.example.ecommerce.sales.products.ProductCatalog;

public class SalesFacade {

    private SystemUserContext systemUserContext;
    private BasketStorage basketStorage;
    private ProductCatalog productCatalog;

    public SalesFacade(SystemUserContext systemUserContext, BasketStorage basketStorage, ProductCatalog productCatalog) {
        this.systemUserContext = systemUserContext;
        this.basketStorage = basketStorage;
        this.productCatalog = productCatalog;
    }

    public void addToBasket(String productId){
        String currentClientId = systemUserContext.getCurrentUserId();

        Basket basket = basketStorage.loadForUser(currentClientId).orElse(
                Basket.empty()
        );
        Product product = productCatalog.load(productId)
                .orElseThrow(NoSuchProductException::new);

        basket.addProduct(product);

        basketStorage.save(currentClientId, basket);
    }

    public Basket getBasket(){
        String currentClientId = systemUserContext.getCurrentUserId();

        return basketStorage.loadForUser(currentClientId).orElse(Basket.empty());
    }
}
