package com.effectivejava.B_MethodsCommontoAllObjects.AlwaysOverrideToString;

import java.math.BigInteger;

public class Car {
    private int id;
    private String model;
    BigInteger sayi;

    public Car(int id, String model) {
        this.id = id;
        this.model = model;
        sayi=BigInteger.TWO;
    }

    //Eğer toString'i override ederseniz, debug modda nesnenin bilgilerine ulaşabilirsiniz.

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", sayi=" + sayi +
                '}';
    }
}
