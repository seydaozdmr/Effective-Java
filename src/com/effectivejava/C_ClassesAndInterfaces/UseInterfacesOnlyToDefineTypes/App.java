package com.effectivejava.C_ClassesAndInterfaces.UseInterfacesOnlyToDefineTypes;


/**
 * Normally a utility class requires clients to qualify constant names with a class
 * name, for example, PhysicalConstants.AVOGADROS_NUMBER. If you make heavy
 * use of the constants exported by a utility class, you can avoid the need for qualifying
 * the constants with the class name by making use of the static import facility:
 */

public class App {
    public static void main(String[] args) {

    }


    static double atoms(double mols) {
        return PhysicalConstantsClass.AVOGADROS_NUMBER * mols;
    }

}
