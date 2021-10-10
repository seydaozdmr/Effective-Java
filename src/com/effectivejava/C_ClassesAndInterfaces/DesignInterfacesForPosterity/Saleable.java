package com.effectivejava.C_ClassesAndInterfaces.DesignInterfacesForPosterity;

public interface Saleable {
    /**
     * Interface tanımlarken dikkatli olun daha sonra oluşabilecek durumları önceden öngörmeye
     * çalışın.
     *
     * interface içerisinde default methodları tanımlayabilmemize olanak tanınsa da interface
     * tanımlarken dikkatli olmak zorundayız ve iyi düşünmeden method yazmamalıyız.
     */

    /**
     * If an interface contains a minor flaw, it
     * may irritate its users forever; if an interface is severely deficient, it may doom the
     * API that contains it.
     */

    double getPrice();
    //bunun gibi default methodları daha sonra implemente edebiliriz, kodu kırmadan
    default double calculateTax(int price, double rate){
        return price*(rate/100);
    }


}
