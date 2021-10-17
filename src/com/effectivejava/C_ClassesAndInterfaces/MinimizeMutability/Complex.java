package com.effectivejava.C_ClassesAndInterfaces.MinimizeMutability;

public final class Complex {
    /**
     *There are many good reasons for this: Immutable
     * classes are easier to design, implement, and use than mutable classes. They are
     * less prone to error and are more secure.
     */
    /**
     * Ensure that the class can’t be extended. This prevents careless or malicious
     * subclasses from compromising the immutable behavior of the class by
     * behaving as if the object’s state has changed. Preventing subclassing is
     * generally accomplished by making the class final, but there is an alternative
     * that we’ll discuss later.
     *
     * Sınıfın immutable olmasını sağlamak için sınıfın başka sınıflar tarafından extend
     * edilmesinin önüne geçmelisiniz.
     *
     * Immutable objects are inherently thread-safe; they require no synchronization.
     */
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     *Now that you know how to make an immutable class and you understand the
     * pros and cons of immutability, let’s discuss a few design alternatives. Recall that
     * to guarantee immutability, a class must not permit itself to be subclassed. This can
     * be done by making the class final, but there is another, more flexible alternative.
     * Instead of making an immutable class final, you can make all of its constructors
     * private or package-private and add public static factories in place of the public
     * constructors (Item 1).
     */
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public static Complex valueOfPolar(double r, double theta) {
        return new Complex(r * Math.cos(theta), r * Math.sin(theta));
    }

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    // Accessors with no corresponding mutators
    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex add(Complex c) {
        /**
         * This pattern is known as the functional approach because methods return
         * the result of applying a function to their operand, without modifying it.
         */
        return new Complex(re + c.re, im + c.im);
    }

    public Complex subtract(Complex c) {
        /**
         * alanlarımız immutable olduğu için sınıf içinde yapılan işlemin sonucu olarak
         * yeni bir nesne dönüyoruz.
         */
        return new Complex(re - c.re , im - c.im );
    }


    /**
     * Not:
     * The performance problem is magnified if you perform a multistep operation
     * that generates a new object at every step, eventually discarding all objects except
     * the final result.
     */
    public Complex multiply(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex divide(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re
                * c.im)
                / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;


        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hashDouble(re);
        result = 31 * result + hashDouble(im);
        return result;
    }

    private int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(re);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}