package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.example.ecommerce.sales.snv" +
		".SalesFacade", "com.example.ecommerce.sales.basket", "com.example.ecommerce.exceptions", "com.example" +
		".ecommerce.modelling", "com.example.ecommerce.ProductCatalog", "com.example.ecommerce.sales.exceptions",
		"com.example.ecommerce.sales.products", "com.example.ecommerce.sales.snv.SalesController", "com.example" +
		".ecommerce.sales.snv.SystemUserContext"})
public class EcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
}
