package com.effectivejava.C_ClassesAndInterfaces.DesignAndDocumentForInheritance;

/**
 * Unless you know there is a real
 * need for subclasses, you are probably better off prohibiting inheritance by declaring
 * your class final or ensuring that there are no accessible constructors.
 */
public abstract class Super {

    /**
     * Constructors must not invoke overridable methods, directly or indirectly.
     */
    public Super() {
        overrideMe();
    }

    public abstract void overrideMe() ;
}