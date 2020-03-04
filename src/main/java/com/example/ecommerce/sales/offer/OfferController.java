package com.example.ecommerce.sales.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OfferController {

    @Autowired
    private OfferFinder offerMaker;

    @RequestMapping("/offer")
    @ResponseBody
    public OfferData offer() {
        return offerMaker.currentOffer();
    }
}
