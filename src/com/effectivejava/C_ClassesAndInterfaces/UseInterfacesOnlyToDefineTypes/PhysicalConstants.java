package com.effectivejava.C_ClassesAndInterfaces.UseInterfacesOnlyToDefineTypes;

public interface PhysicalConstants {
    // Avogadro's number (1/mol)
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    // Boltzmann constant (J/K)
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
    // Mass of the electron (kg)
    static final double ELECTRON_MASS = 9.109_383_56e-31;

    /**
     * One kind of interface that fails this test is the so-called constant interface.
     * Such an interface contains no methods; it consists solely of static final fields, each
     * exporting a constant. Classes using these constants implement the interface to
     * avoid the need to qualify constant names with a class name. Here is an example:
     * // Constant interface antipattern - do not use!
     */
}
