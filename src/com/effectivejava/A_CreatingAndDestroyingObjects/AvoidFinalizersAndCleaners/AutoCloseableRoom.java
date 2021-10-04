package com.effectivejava.A_CreatingAndDestroyingObjects.AvoidFinalizersAndCleaners;

public class AutoCloseableRoom implements AutoCloseable{
    private int numJunkPiles;

    public AutoCloseableRoom(int numJunkPiles) {
        this.numJunkPiles = numJunkPiles;
    }

    @Override
    public void close() throws Exception {
        this.numJunkPiles=0;
        System.out.println("this numJunkPiles : "+ this.numJunkPiles);
    }

    public int getNumJunkPiles() {
        return numJunkPiles;
    }
}
