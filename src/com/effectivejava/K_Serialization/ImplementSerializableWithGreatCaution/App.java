package com.effectivejava.K_Serialization.ImplementSerializableWithGreatCaution;

public class App {
    /**
     * A major cost of implementing Serializable is that it decreases the
     * flexibility to change a class’s implementation once it has been released.
     */

    /**
     * Clients attempting to serialize an instance using an old version of the class and deserialize
     * it using the new one (or vice versa) will experience program failures.
     */

    /**
     * A second cost of implementing Serializable is that it increases the likelihood
     * of bugs and security holes (Item 85).
     */
}
