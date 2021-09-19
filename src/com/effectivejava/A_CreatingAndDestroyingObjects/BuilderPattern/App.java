package com.effectivejava.A_CreatingAndDestroyingObjects.BuilderPattern;

public class App {
    /**
     * Çok fazla alana sahip sınıfların yaratımsal süreçlerinde teleskopik constructorlar ya da
     * setter kullanmak yerine builder pattern kullanabilirsiniz.
     *
     */

    public static void main(String[] args) {
        NutritionFacts facts=new NutritionFacts.NutritionBuilder(10,200).build();
        System.out.println(facts);

    }
}
