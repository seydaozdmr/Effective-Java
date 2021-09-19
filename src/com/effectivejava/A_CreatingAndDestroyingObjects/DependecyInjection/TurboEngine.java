package com.effectivejava.A_CreatingAndDestroyingObjects.DependecyInjection;

public class TurboEngine implements Engine{
    @Override
    public void startEngine() {
        System.out.println("Turbo engine has started..");
    }
}
