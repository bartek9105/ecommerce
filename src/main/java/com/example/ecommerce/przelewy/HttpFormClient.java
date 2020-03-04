package com.example.ecommerce.przelewy;

import java.util.Map;

public interface HttpFormClient {
    String post(String url, Map<String, String> params);
}
