package com.example.ecommerce.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfiguration {
    @Bean
    SystemUserContext systemUserContext() {
        return new InMemorySystemUserContext();
    }
}
