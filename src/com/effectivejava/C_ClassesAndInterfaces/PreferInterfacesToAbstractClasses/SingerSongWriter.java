package com.effectivejava.C_ClassesAndInterfaces.PreferInterfacesToAbstractClasses;

public interface SingerSongWriter extends Singer,SongWriter{
    //gerçek hayatta bir şarkıcı aynı zamanda şarkı yazarı da olabilir.

    int sayi=100;


    public static int calculate() {
        return 0;
    }

    void ActSensitive();
    //interface içerisinde default method tanımlayabiliriz.
    default void strum(){
        System.out.println("playing something");
        System.out.println(sayi);
    }

    /**
     * You can, however, combine the advantages of interfaces and abstract classes
     * by providing an abstract skeletal implementation class to go with an interface. The
     * interface defines the type, perhaps providing some default methods, while the
     * skeletal implementation class implements the remaining non-primitive interface
     * methods atop the primitive interface methods. Extending a skeletal implementation
     * takes most of the work out of implementing an interface. This is the Template
     * Method pattern [Gamma95].
     */

}
