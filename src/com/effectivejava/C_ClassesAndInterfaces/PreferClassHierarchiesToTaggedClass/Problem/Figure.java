package com.effectivejava.C_ClassesAndInterfaces.PreferClassHierarchiesToTaggedClass.Problem;

class Figure {
    /**
     * A tagged class is just a pallid imitation of a class hierarchy.
     */
    enum Shape { RECTANGLE, CIRCLE  };

    /**
     * Such tagged classes have numerous shortcomings. They are cluttered with
     * boilerplate, including enum declarations, tag fields, and switch statements. Readability
     * is further harmed because multiple implementations are jumbled together
     * in a single class. Memory footprint is increased because instances are burdened
     * with irrelevant fields belonging to other flavors.
     *
     * shape içerisinde rectangle'ı ilgilendiren alanları doldurduğumuzda cirle ilgilendiren
     * alanlar boş kalır ve yer kaplar, tam tersi de olabilir.
     */

    // Tag field - the shape of this figure
    final Shape shape;

    // These fields are used only if shape is RECTANGLE
    double length;
    double width;

    // This field is used only if shape is CIRCLE
    double radius;

    // Constructor for circle
    Figure(double radius) {
        /**
         * Constructors must set the tag field and initialize the right data fields
         * with no help from the compiler:
         * if you initialize the wrong fields, the program will fail at runtime.
         */

        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch(shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }

    public static void main(String[] args) {
        Figure figure = new Figure(3,4);
        System.out.println(figure.area());

        /**
         * In summary, tagged classes are seldom appropriate. If you’re tempted to write
         * a class with an explicit tag field, think about whether the tag could be eliminated
         * and the class replaced by a hierarchy. When you encounter an existing class with a
         * tag field, consider refactoring it into a hierarchy.
         */
    }
}
