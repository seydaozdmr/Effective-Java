package com.effectivejava.D_Generics.DontUseRawTypes;

import java.util.Collection;

public class App {

    private static Collection coffies;
    public static void main(String[] args) {
        coffies.add(new Coffie("Latte"));
        /**
         * As mentioned throughout this book, it pays to discover errors as soon as possible
         * after they are made, ideally at compile time.
         * raw type kullanırsak istemediğimiz tiplerden elemanlar da ekleyebiliriz.
         * bu ise run time da hataya sebep olacaktır.
         */
        coffies.add(new App().new Tea("asdas"));

    }

    class Tea{
        private String name;

        public Tea(String name) {
            this.name = name;
        }
    }
}
