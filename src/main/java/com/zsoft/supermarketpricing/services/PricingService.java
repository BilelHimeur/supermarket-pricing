package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.exceptions.ProductNotFoundException;
import com.zsoft.supermarketpricing.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PricingService {

    ProductService productService;
    @Autowired
    public PricingService(ProductService productService) {
        this.productService = productService;
    }

    public double getSimplePricing(long productId, int quantity) throws ProductNotFoundException{
        Optional<Product> productOptional = productService.getProductById(productId);
        if (productOptional.isPresent()) {
            return productOptional.get().getPrice().getValue() * quantity;
        } else {
            throw new ProductNotFoundException(productId);
        }
    }
}
