package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example.ecommerce.sales.SalesFacade","com.example.ecommerce.modelling",
		"com.example" +
		".ecommerce.ProductCatalog","com.example.ecommerce.exceptions"})
public class EcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
}
