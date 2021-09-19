package com.effectivejava.A_CreatingAndDestroyingObjects.DependecyInjection;

public class Mosaic implements Tile {
    private String description;

    public Mosaic(String description) {
        this.description = description;
    }

    public Mosaic(){}

    @Override
    public String getDescription() {
        return description;
    }
}
