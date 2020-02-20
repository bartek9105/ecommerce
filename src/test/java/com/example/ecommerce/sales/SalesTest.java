package com.example.ecommerce.sales;

import com.example.ecommerce.sales.basket.Basket;
import com.example.ecommerce.sales.basket.InMemoryBasketStorage;
import com.example.ecommerce.sales.products.InMemoryProductCatalog;
import com.example.ecommerce.sales.products.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SalesTest {

    private final String PRODUCT_ID = "1000";
    private String currentUserId;
    private InMemoryProductCatalog productCatalog;

    @Before
    public void setup(){
        this.productCatalog = new InMemoryProductCatalog();
    }

    @Test
    public void itAllowsProductToBasket(){
        thereIsClientIdentifiedWith("client_1");
        thereIsProductAvailableInCatalog(PRODUCT_ID);
        SalesFacade salesFacade = thereIsSalesFacade();

        salesFacade.addToBasket(PRODUCT_ID);
        Basket basket = salesFacade.getBasket();

        assertThat(basket.productsCount()).isEqualTo(1);
    }

    private void thereIsProductAvailableInCatalog(String productId) {
        this.productCatalog.setAvailableProducts(Arrays.asList(new Product(productId, BigDecimal.valueOf(10.0))));
    }

    private void thereIsClientIdentifiedWith(String clientId)  {
        this.currentUserId = clientId;
    }

    @Test
    public void itAllowsAddProductToBasketBy2SeparatedClients(){
        thereIsClientIdentifiedWith("client_1");
        SalesFacade salesFacade = thereIsSalesFacade();
        salesFacade.addToBasket(PRODUCT_ID);
        Basket basketOwnedBy1 = salesFacade.getBasket();

        thereIsClientIdentifiedWith("client_2");
        salesFacade.addToBasket(PRODUCT_ID);
        Basket basketOwnedBy2 = salesFacade.getBasket();

        assertThat(basketOwnedBy2).isNotEqualTo(basketOwnedBy1);
    }

    private SalesFacade thereIsSalesFacade(){

        return new SalesFacade(
                () -> currentUserId,
                new InMemoryBasketStorage(),
                this.productCatalog);
    }
}
