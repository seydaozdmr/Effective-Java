package com.effectivejava.A_CreatingAndDestroyingObjects.AvoidFinalizersAndCleaners;

import java.math.BigInteger;
import java.time.Instant;
import java.util.*;

public class StaticFactoryMethod {
    public static void main(String[] args) {
        //Student student=Student.getInstance("hasan","hasan@gmail.com");

        Date date=Date.from(Instant.now());
        List<String> isimler=List.of("ali","mustafa","hüseyin");
        BigInteger prime=BigInteger.valueOf(Integer.MAX_VALUE);

    }

}
