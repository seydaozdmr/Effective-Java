package com.effectivejava.K_Serialization.PreferAlternativesToJavaSerialization;

public class App {
    /**
     * When serialization was added to Java in 1997, it was known to be somewhat risky.
     * The approach had been tried in a research language (Modula-3) but never in a
     * production language. While the promise of distributed objects with little effort on
     * the part of the programmer was appealing, the price was invisible constructors and
     * blurred lines between API and implementation, with the potential for problems
     * with correctness, performance, security, and maintenance. Proponents believed
     * the benefits outweighed the risks, but history has shown otherwise.
     */

    /**
     * In summary, serialization is dangerous and should be avoided. If you are
     * designing a system from scratch, use a cross-platform structured-data representation
     * such as JSON or protobuf instead. Do not deserialize untrusted data. If you
     * must do so, use object deserialization filtering, but be aware that it is not guaranteed
     * to thwart all attacks. Avoid writing serializable classes. If you must do so,
     * exercise great caution.
     */
}
