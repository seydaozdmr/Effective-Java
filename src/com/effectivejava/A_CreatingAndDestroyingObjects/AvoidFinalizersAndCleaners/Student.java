package com.effectivejava.A_CreatingAndDestroyingObjects.AvoidFinalizersAndCleaners;

public class Student {

    /***
     * Birden fazla constructor'ın kullanılması gereken durumlarda eğer farklı method signature ile
     * constructor'ları yönetmeye çalışırsak zamanla hangi constructor'ın hangi amaç için yaratıldığını
     * karıştırabiliriz. Fakar static factory method'a vereceğimiz isim ile yaratılacak nesne hakkında
     * belirli fikire sahip olabilir.
     */
    private long id;
    private String name;
    private String email;

    private Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static Student getInstance(String name,String email){
        return new Student(name,email);
    }
}
