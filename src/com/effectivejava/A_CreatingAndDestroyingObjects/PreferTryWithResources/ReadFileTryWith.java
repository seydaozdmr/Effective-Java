package com.effectivejava.A_CreatingAndDestroyingObjects.PreferTryWithResources;

import java.io.*;

public class ReadFileTryWith {
    public static void main(String[] args) {
        File file=new File("test.txt");

        try {
            System.out.println(firstLineOfFile(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            copy(file.getAbsolutePath(),"test2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String firstLineOfFile(File file) throws IOException {
        try(BufferedReader reader= new BufferedReader(new FileReader(file))){
            return reader.readLine();
        }
    }

    public static void copy(String src , String dst) throws IOException{
        try(InputStream in=new FileInputStream(src);OutputStream outputStream=new FileOutputStream(dst)){
            byte[] buf=new byte[1024];
            int n;
            while((n=in.read(buf))>=0){
                outputStream.write(buf,0,n);
            }
        }
    }
}
