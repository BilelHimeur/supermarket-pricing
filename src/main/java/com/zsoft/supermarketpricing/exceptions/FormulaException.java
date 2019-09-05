package com.zsoft.supermarketpricing.exceptions;

public class FormulaException extends Exception {
    String formulaExpression;
    public FormulaException(String formulaExpression) {
        super("The formula " + formulaExpression + " does not exist yet");
    }
}
