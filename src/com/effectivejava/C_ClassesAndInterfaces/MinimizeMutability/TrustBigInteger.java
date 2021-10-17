package com.effectivejava.C_ClassesAndInterfaces.MinimizeMutability;

import java.math.BigInteger;

public class TrustBigInteger {

    /**
     * BigInteger sınıfından gelen nesnelerin extend edilip edilmediğini anlamak için
     * bu methodla kontrol ediyoruz.
     */
    public static BigInteger safeInstance(BigInteger val) {
        return val.getClass() == BigInteger.class ?
                val : new BigInteger(val.toByteArray());
    }
}
