package com.effectivejava.B_MethodsCommontoAllObjects.OverridingEquals;

import java.util.Objects;

public class Car {
    private int id;
    private String model;
    private String brand;

    public Car(int id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }


    /***
     *
     * @param o car object
     * Eğer aşağıdaki durumlardan biri gerçekleşiyorsa equals methodunu override etmeyin
     * 1- Sınıfın her bir nesnesi doğal olarak eşsizse -> Bu değerler yerine aktif varlıkları temsil eden Thread gibi sınıflar için geçerlidir.
     * 2- Sınıf için mantıksal denklik testine gerek duyulmuyorsa -> Mesela regex.Pattern gibi sınıflarda iki farklı Pattern instance'ının eşitliği
     * equals ile kontrol edilebilir, fakat sınıfı tasarlayanlar istemcilerin bu fonksiyonu kullanmayacağını düşünmüşlerdir. Bu durumda Object sınıfından
     * miras alınaması idealdir.
     * 3- Superclass equals'ı override etmiştir ve bu üst sınıfın davranışı alt sınıf için uygundur. Bu durumda alt sınıfta tekrar override etmeye
     * gerek yoktur.
     * 4- Sınıf private ve ya package-private ise ve bu sınıfın equals methodunun çağırılmayacağına emin isek.
     *          Eğer bu durumun garanti olmasını istiyorsak:
     * @Override public boolean equals(Object o) {
     * throw new AssertionError(); // Method is never called
     * }
     *
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(model, car.model) && Objects.equals(brand, car.brand);
    }

    /**
     * Equals'ı override ettiğimizde karşılaşmamız gereken durumlar :
     * Dönüşlülük -> x.equals(x) true olmalı
     * Simetriklik -> x.equals(y) ise y.equals(x) true olmalı
     * Geçişli -> x.equals(y) ve y.equals(z) ise x.equals(z) true olmalı.
     * Tutarlılık -> yapılan karşılaştırmaların her koşulda true ya da false gelmesi
     * x.equals(null) x'in null olmadığı her durumda false gelmek zorundadır.
     *
     *
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand);
    }
}
