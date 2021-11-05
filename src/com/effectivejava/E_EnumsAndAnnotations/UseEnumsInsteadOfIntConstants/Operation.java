package com.effectivejava.E_EnumsAndAnnotations.UseEnumsInsteadOfIntConstants;

import java.util.Map;
import java.util.stream.Stream;

//static toMap method
import static java.util.stream.Collectors.toMap;

public enum Operation {
    PLUS,MINUS,TIMES,DIVIDE;



    public double apply(double x, double y) {
        switch (this){
            case PLUS : return x+y;
            case MINUS : return x-y;
            case TIMES: return x*y;
            case DIVIDE : return x/y;
        }
        throw new AssertionError("Unknows operation " +this);
    }

    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));
}
