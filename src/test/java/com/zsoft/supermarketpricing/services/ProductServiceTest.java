package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.models.Product;
import com.zsoft.supermarketpricing.repository.ProductRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.Assert.*;
import java.util.Optional;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    @Autowired
    ProductService productService;
    @MockBean
    ProductRepository productRepository;

    @Test
    public void getProductByIdTest() {
        //given
        long idProduct = 1L;
        Product product = Product.builder()
                .id(idProduct)
                .name("productNameExample")
                .build();
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        //when
        Optional<Product> maybeProduct = productService.getProductById(product.getId());

        //then
        assertTrue(maybeProduct.isPresent());
        assertEquals(maybeProduct.get().getId(), product.getId());
        assertEquals(maybeProduct.get().getName(), product.getName());

    }
}
