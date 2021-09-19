package com.effectivejava.A_CreatingAndDestroyingObjects.DependecyInjection;

public class Car {
    //we use dependency injection
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void driveCar(){
        engine.startEngine();
    }


}
