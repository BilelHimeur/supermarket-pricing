package com.zsoft.supermarketpricing.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(long productId) {
        super("The product with " + productId + " id does not exist");
    }
}
