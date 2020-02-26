package com.example.ecommerce;

import com.example.ecommerce.productcatalog.Product;
import com.example.ecommerce.productcatalog.ProductCatalogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;

@SpringBootApplication
public class EcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Autowired
	ProductCatalogFacade productCatalogFacade;

	@EventListener(value = ApplicationStartedEvent.class)
	public void putSomeProductsOnStart() {
		productCatalogFacade.create(Product.builder()
				.name("Clean Code : A Handbook of Agile Software Craftsmanship")
				.published(true)
				.price(BigDecimal.valueOf(120))
				.cover("https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1323/9780132350884.jpg")
				.description("Even bad code can function. But if code isn't clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn't have to be that way.")
				.build()
		);

		productCatalogFacade.create(Product.builder()
				.name("The Pragmatic Programmer : your journey to mastery")
				.published(true)
				.price(BigDecimal.valueOf(140))
				.cover("https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1359/9780135957059.jpg")
				.description("The Pragmatic Programmer is one of those rare tech books you'll read, re-read, and read again over the years. Whether you're new to the field or an experienced practitioner, you'll come away with fresh insights each and every time.")
				.build()
		);
	}
}
