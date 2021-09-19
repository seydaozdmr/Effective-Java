package com.effectivejava.A_CreatingAndDestroyingObjects.UseSingletonEnum;

public class TestSingletonEnum {
    public static void main(String[] args) {
        Runnable r1=() -> {
            SingletonEnum singletonEnum=SingletonEnum.getInstance();
            singletonEnum.getConnection("jdbc:mysql://localhost:3306/denizhal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "23892389Sey.");
        };

        for(int i=0;i<1000;i++){
            Thread thread=new Thread(r1);
            thread.start();
        }
    }
}
