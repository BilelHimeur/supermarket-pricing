package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.exceptions.ProductNotFoundException;
import com.zsoft.supermarketpricing.models.Price;
import com.zsoft.supermarketpricing.models.Product;
import com.zsoft.supermarketpricing.models.enums.Unit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class PricingServiceTest {
    @MockBean
    ProductService productService;
    @Autowired
    PricingService pricingService;

    @Test
    public void getSimplePricing() throws ProductNotFoundException {
        // given
        Price price = Price.builder()
                .unit(Unit.UNIT)
                .value(60)
                .build();
        Product product = Product.builder()
                .id(2)
                .name("productName")
                .price(price)
                .build();
        int quantity = 7;
        // when
        when(productService.getProductById(2)).thenReturn(Optional.of(product));
        double simplePrice = pricingService.getSimplePricing(product.getId(), quantity);

        // then
        assertTrue(simplePrice ==  60 * 7);

    }

    @Test
    public void getPricingByWeightTest() {
        // given
        Price price = Price.builder()
                .unit(Unit.OUNCE)
                .value(60)
                .build();
        Product product = Product.builder()
                .id(2)
                .name("productName")
                .price(price)
                .build();
        float weight = 7;
        // when
        when(productService.getProductById(2)).thenReturn(Optional.of(product));
        double priceByWeight = pricingService.getPriceByWeight(product.getId(), weight, price.getUnit());

        // then
        assertTrue(priceByWeight ==  60 * 1 / 16F * 7);

    }
}
