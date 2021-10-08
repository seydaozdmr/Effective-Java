package com.effectivejava.B_MethodsCommontoAllObjects.OverridingEquals;

import java.util.Objects;

public class CaseInsentiveString {
    private final String s;

    public CaseInsentiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CaseInsentiveString){
            return s.equalsIgnoreCase(((CaseInsentiveString) obj).s);
        }

//        if(obj instanceof String)
//            return s.equalsIgnoreCase((String) obj);
        return false;
    }


}
