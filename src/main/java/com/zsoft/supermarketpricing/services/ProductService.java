package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;
}
