package com.effectivejava.C_ClassesAndInterfaces.InPublicClassesUseAccessorMethods;

public class Point {
    /**
     * While it’s never a good idea for a public class to expose fields directly, it is
     * less harmful if the fields are immutable. You can’t change the representation of
     * such a class without changing its API, and you can’t take auxiliary actions when a
     * field is read, but you can enforce invariants.
     */

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
