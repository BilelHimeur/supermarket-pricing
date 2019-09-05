package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.models.Product;
import com.zsoft.supermarketpricing.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;
    public Optional<Product> getProductById(long productId) {
        return this.productRepository.findById(productId);
    }
}
