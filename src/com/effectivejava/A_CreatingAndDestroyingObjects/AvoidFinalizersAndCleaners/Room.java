package com.effectivejava.A_CreatingAndDestroyingObjects.AvoidFinalizersAndCleaners;



public class Room{


    int numJunkPiles; // Number of junk piles in this room
    Thread thread;
    public Room(int numJunkPiles) {
        this.numJunkPiles = numJunkPiles;

        thread = new Thread(()->{
           this.numJunkPiles=0;
        });

        thread.start();
    }

    public void run(){
        this.numJunkPiles=0;
    }


}
