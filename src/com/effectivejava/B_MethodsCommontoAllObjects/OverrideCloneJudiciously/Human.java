package com.effectivejava.B_MethodsCommontoAllObjects.OverrideCloneJudiciously;

public class Human implements Cloneable{
    /**
     * The Cloneable interface was intended as a mixin interface (Item 20) for classes to
     * advertise that they permit cloning.
     */

    private int id;
    private String name;
    private String lastname;
    private String [] cars;

    public Human(int id, String name, String lastname, String[] cars) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.cars = cars;
    }


    @Override
    protected Human clone() {
        //eğer sınıf içerisinde mutable alanlar varsa bunlar da clone() ile kopyalanmalıdır.
        // not : eğer cars dizisi final olursa clone() çalışmaz...
        try{
            Human human=(Human) super.clone();
            human.cars=cars.clone();
            return human;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
