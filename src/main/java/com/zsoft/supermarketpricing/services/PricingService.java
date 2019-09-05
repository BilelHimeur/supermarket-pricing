package com.zsoft.supermarketpricing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingService {

    ProductService productService;
    @Autowired
    public PricingService(ProductService productService) {
        this.productService = productService;
    }

    public double getSimplePricing(long productId, int quantity) {
        return 0;
    }
}
