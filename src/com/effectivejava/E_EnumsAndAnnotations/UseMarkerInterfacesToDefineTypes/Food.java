package com.effectivejava.E_EnumsAndAnnotations.UseMarkerInterfacesToDefineTypes;

import java.io.Serializable;
//Serializable is marker interface
public class Food implements Serializable {
    /**
     * A marker interface is an interface that contains no method declarations but merely
     * designates (or “marks”) a class that implements the interface as having some
     * property. For example, consider the Serializable interface (Chapter 12). By
     * implementing this interface, a class indicates that its instances can be written to an
     * ObjectOutputStream (or “serialized”).
     */

    /**
     * So when should you use a marker annotation and when should you use a
     * marker interface? Clearly you must use an annotation if the marker applies to any
     * program element other than a class or interface, because only classes and interfaces
     * can be made to implement or extend an interface.
     */
}
