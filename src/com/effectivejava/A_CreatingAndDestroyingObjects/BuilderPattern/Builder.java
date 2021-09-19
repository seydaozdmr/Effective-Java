package com.effectivejava.A_CreatingAndDestroyingObjects.BuilderPattern;

public interface Builder {
    Builder calories(int value);
    Builder fat(int value);
    Builder sodium(int value);
    Builder carbohydrate(int value);
}
