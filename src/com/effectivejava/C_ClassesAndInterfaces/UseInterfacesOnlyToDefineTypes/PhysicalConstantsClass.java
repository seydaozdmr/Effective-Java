package com.effectivejava.C_ClassesAndInterfaces.UseInterfacesOnlyToDefineTypes;


public class PhysicalConstantsClass {
    // sabitleri interface'de tanımlamak yerine sınıf içerisinde tanımlamak, interface'i impelemente
    // eden istemcilerin kodun içeriğini bilmesine yol açabilir.
    private PhysicalConstantsClass()  {
        //you can not instance this class
        /**
         * In summary, interfaces should be used only to define types. They should not
         * be used merely to export constants.
         */
    }

    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    public static final double BOLTZMANN_CONST = 1.380_648_52e-23;
    public static final double ELECTRON_MASS = 9.109_383_56e-31;
}
