package com.effectivejava.A_CreatingAndDestroyingObjects.AvoidFinalizersAndCleaners;

import java.lang.ref.Cleaner;

public class CleanerRoom implements AutoCloseable{
    private static final Cleaner cleaner=Cleaner.create();



    private static class Room implements Runnable{
        int numJunkPiles;

        public Room(int numJunkPiles){
            this.numJunkPiles=numJunkPiles;
        }

        @Override
        public void run(){
            System.out.println("The room is cleaning");
            numJunkPiles=0;
        }
    }

    private final Room room;

    private final Cleaner.Cleanable cleanable;

    public CleanerRoom(int numJunkPiles){
        room = new Room(numJunkPiles);
        cleanable= cleaner.register(this,room);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }


}
