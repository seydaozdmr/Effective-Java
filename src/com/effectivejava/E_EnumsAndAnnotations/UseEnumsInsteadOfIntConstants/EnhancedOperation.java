package com.effectivejava.E_EnumsAndAnnotations.UseEnumsInsteadOfIntConstants;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public enum EnhancedOperation {
    PLUS("+") { public double apply(double x,double y) {return x+y;}},
    MINUS("-") { public double apply (double x,double y) {return x-y;}},
    TIMES("*") {public double apply(double x,double y) {return x*y;}},
    DIVIDE("/") {public double apply (double x,double y) {return x/y;} };

    private String symbol;

    EnhancedOperation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return this.symbol;
    }


}
