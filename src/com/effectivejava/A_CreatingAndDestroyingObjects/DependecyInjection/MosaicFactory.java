package com.effectivejava.A_CreatingAndDestroyingObjects.DependecyInjection;

import java.util.function.Supplier;

public class MosaicFactory implements Factory{
    @Override
    public Mosaic create(Supplier<? extends Tile> tileFactory) {
        return (Mosaic) tileFactory.get();
    }

    public static void main(String[] args) {
        MosaicFactory factory=new MosaicFactory();
        Mosaic mosaic=factory.create(Mosaic::new);
    }


}
