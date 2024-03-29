package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.exceptions.FormulaException;
import com.zsoft.supermarketpricing.exceptions.ProductNotFoundException;
import com.zsoft.supermarketpricing.models.Product;
import com.zsoft.supermarketpricing.models.enums.Formula;
import com.zsoft.supermarketpricing.models.enums.Unit;
import com.zsoft.supermarketpricing.utils.FormulaUtils;
import com.zsoft.supermarketpricing.utils.UnitConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PricingService {

    ProductService productService;
    UnitConvertor convertor;
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

    public double getPriceByWeight (long productId, float weight, Unit unit) throws ProductNotFoundException{
        Optional<Product> product = productService.getProductById(productId);
        if (product.isPresent()) {
            return product.get().getPrice().getValue() * convertor.apply(product.get().getPrice().getUnit(), unit) * weight;
        } else {
            throw new ProductNotFoundException(productId);
        }
    }

    public double getPriceUsingFormula (long productId, float quantity, Formula formula) throws FormulaException, ProductNotFoundException {
        Optional<Product> productOptional = productService.getProductById(productId);
        if (productOptional.isPresent()) {
            return FormulaUtils.getPriceFromFormula(quantity, formula, productOptional.get().getPrice().getValue());
        } else {
            throw new ProductNotFoundException(productId);
        }
    }
}
