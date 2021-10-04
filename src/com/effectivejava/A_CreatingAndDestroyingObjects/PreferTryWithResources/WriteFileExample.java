package com.effectivejava.A_CreatingAndDestroyingObjects.PreferTryWithResources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFileExample {
    public static void main(String[] args) {
        File file=new File("test.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writeLine(file,"merhaba dünya");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void writeLine(File file, String s) throws IOException {
        BufferedWriter br=null;

        try {
            br=new BufferedWriter(new FileWriter(file));
            br.write(s);
            System.out.println("writing");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
        }
    }
}
