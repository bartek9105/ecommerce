package com.example.ecommerce.productcatalog;

import com.example.ecommerce.productcatalog.dto.ProductData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    BigDecimal price;
    Boolean published;
    String cover;

    public ProductData toData(){
        return new ProductData(id, name, price);
    }
}
