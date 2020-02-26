package com.example.ecommerce.system;

public class InMemorySystemUserContext implements SystemUserContext {

    @Override
    public String getCurrentUserId() {
        return "1";
    }
}
