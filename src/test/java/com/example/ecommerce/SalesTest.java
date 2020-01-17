package com.example.ecommerce;

import com.example.ecommerce.Sales.SalesFacade;
import org.junit.jupiter.api.Test;

public class SalesTest {
    @Test
    public void itAllowsProductToBasket(){
        thereIsClientIdentifiedWith("client_1");
        SalesFacade salesFacade = thereIsSalesFacade();

        salesFacade.addToBasket(PRODUCT_ID);
        Basket basket = salesFacade.getBasket();

        assertThat(basket.productsCount()).isEqual(1);
    }

    private void thereIsClientIdentifiedWith(String client_1) {

    }

    @Test
    public void itAllowsProductToBasket(){
        thereIsClientIdentifiedWith("client_2");
        SalesFacade salesFacade = thereIsSalesFacade();

        salesFacade.addToBasket(PRODUCT_ID);
        Basket basket = salesFacade.getBasket();

        assertThat(basket.productsCount()).isEqual(2);
    }

}
