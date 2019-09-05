package com.zsoft.supermarketpricing.utils;

import com.zsoft.supermarketpricing.exceptions.FormulaException;
import com.zsoft.supermarketpricing.models.enums.Formula;

public class FormulaUtils {

    public static double getPriceFromFormula(float quantity, Formula formula, double unitPrice) throws FormulaException{
        switch (formula) {
            case THREE_FOR_ONE :
                return quantity / 3 + quantity % 3 * unitPrice;
            default:
                throw new FormulaException(formula.name());
        }
    }
}
