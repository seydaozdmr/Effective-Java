package com.effectivejava.A_CreatingAndDestroyingObjects.AvoidFinalizersAndCleaners;


public class Adult {
    public static void main(String[] args) throws Exception {

        Room room = new Room(10);
        //Clean the room automagically
        System.out.println(room.numJunkPiles); // clean numJunkPiles to zero

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(room.numJunkPiles);


        try(AutoCloseableRoom autoCloseableRoom = new AutoCloseableRoom(100)){
            System.out.println(autoCloseableRoom.getNumJunkPiles());
        }





    }
}
