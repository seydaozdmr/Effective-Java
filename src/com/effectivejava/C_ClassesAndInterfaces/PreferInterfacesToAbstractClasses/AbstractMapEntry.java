package com.effectivejava.C_ClassesAndInterfaces.PreferInterfacesToAbstractClasses;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractMapEntry<K,V> implements Map.Entry<K,V> {
    /**
     * To summarize, an interface is generally the best way to define a type that
     * permits multiple implementations. If you export a nontrivial interface, you should
     * strongly consider providing a skeletal implementation to go with it. To the extent
     * possible, you should provide the skeletal implementation via default methods on
     * the interface so that all implementors of the interface can make use of it. That said,
     * restrictions on interfaces typically mandate that a skeletal implementation take the
     * form of an abstract class.
     *
     * Map.Entry inteface'i için iskelet abstract sınıf yarattık böylece interface içerisinde
     * tanımlayamayacağımız bazı methodları bu sınıf içerisinde implemente edebildik.
     */

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Note that this skeletal implementation could not be implemented in the
     * Map.Entry interface or as a subinterface because default methods are not permitted
     * to override Object methods such as equals, hashCode, and toString.
     */

    @Override
    public int hashCode() {
        return Objects.hash(getKey()) ^ Objects.hash(getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(!(obj instanceof Map.Entry))
            return false;
        Map.Entry<?,?> e = (Map.Entry) obj;
        return Objects.equals(e.getKey() , this.getKey()) && Objects.equals(e.getValue() ,this.getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
