package com.effectivejava.E_EnumsAndAnnotations.UseEnumsInsteadOfIntConstants;

public enum Apple {
    /**
     * Programs that use int enums are brittle. Because int enums are constant
     * variables [JLS, 4.12.4], their int values are compiled into the clients that use them
     * [JLS, 13.1]. If the value associated with an int enum is changed, its clients must be
     * recompiled. If not, the clients will still run, but their behavior will be incorrect.
     */

    /**
     * There is no easy way to translate int enum constants into printable strings. If
     * you print such a constant or display it from a debugger, all you see is a number,
     * which isn’t very helpful. There is no reliable way to iterate over all the int enum
     * constants in a group, or even to obtain the size of an int enum group.
     */

    /**
     * You may encounter a variant of this pattern in which String constants are
     * used in place of int constants. This variant, known as the String enum pattern, is
     * even less desirable. While it does provide printable strings for its constants, it can
     * lead naive users to hard-code string constants into client code instead of using
     * field names. If such a hard-coded string constant contains a typographical error, it
     * will escape detection at compile time and result in bugs at runtime. Also, it might
     * lead to performance problems, because it relies on string comparisons.
     *
     * Cinsiyet gibi sabit değerler sabit String değişkenlerle ifade edilirse bu problemlerle
     * karşılaşılır. Bundan dolayı bu tarz değerleri Enum içinde tanımlamak daha doğrudur.
     */

    FUJI(1), PIPPIN(2), GRANNY_SMITH(3);

    private int id;

    Apple(int i) {
        id=i;
    }

    public int getId(){
        return id;
    }
    /**
     * To associate data with
     * enum constants, declare instance fields and write a constructor that takes the
     * data and stores it in the fields.
     */


}
