package com.effectivejava.G_Methods.DesignMethodSignaturesCarefully;

public class App {
    /**
     * This item is a grab bag of API design hints that don’t quite deserve items of their
     * own. Taken together, they’ll help make your API easier to learn and use and less
     * prone to errors.
     * Choose method names carefully. Names should always obey the standard
     * naming conventions (Item 68). Your primary goal should be to choose names that
     * are understandable and consistent with other names in the same package. Your
     * secondary goal should be to choose names consistent with the broader consensus,
     * where it exists. Avoid long method names. When in doubt, look to the Java library
     * APIs for guidance. While there are plenty of inconsistencies—inevitable, given
     * the size and scope of these libraries—there is also a fair amount of consensus.
     *
     *
     * Don’t go overboard in providing convenience methods. Every method
     * should “pull its weight.” Too many methods make a class difficult to learn, use,
     * document, test, and maintain.
     *
     * Avoid long parameter lists.
     *
     * There are three techniques for shortening overly long parameter lists. One is
     * to break the method up into multiple methods, each of which requires only a subset
     * of the parameters.
     *
     * A second technique for shortening long parameter lists is to create helper
     * classes to hold groups of parameters. Typically these helper classes are static
     * member classes (Item 24).
     *
     * A third technique that combines aspects of the first two is to adapt the Builder
     * pattern (Item 2) from object construction to method invocation. If you have a
     * method with many parameters, especially if some of them are optional, it can be
     * beneficial to define an object that represents all of the parameters and to allow the
     * client to make multiple “setter” calls on this object, each of which sets a single
     * parameter or a small, related group.
     *
     * For parameter types, favor interfaces over classes (Item 64). If there is an
     * appropriate interface to define a parameter, use it in favor of a class that
     * implements the interface.
     *
     * Prefer two-element enum types to boolean parameters, unless the meaning
     * of the boolean is clear from the method name.
     * Örnek:
     */

    enum Cinsiyet{
        KADIN,ERKEK;
    }

    public void kullanmaSaatleri(Cinsiyet cinsiyet){
        if (cinsiyet == Cinsiyet.ERKEK){
            System.out.println("Sabah 10 - 12");
        }else if (cinsiyet==Cinsiyet.KADIN){
            System.out.println("Öğleden sonra 14 - 16");
        }
    }
}
