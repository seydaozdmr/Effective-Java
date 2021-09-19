package com.effectivejava.A_CreatingAndDestroyingObjects.DependecyInjection;

import java.util.function.Supplier;

public interface Factory {
    Mosaic create(Supplier<? extends Tile> tileFactory);
}
