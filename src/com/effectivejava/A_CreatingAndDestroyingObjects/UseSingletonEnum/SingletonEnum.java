package com.effectivejava.A_CreatingAndDestroyingObjects.UseSingletonEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum SingletonEnum {
    CONNECTION;

    private Connection connection;
    private int ids;

    private SingletonEnum(){
        System.out.println("in singleton enum");
        ids++;
    }

    public static SingletonEnum getInstance(){
        return CONNECTION;
    }

    public Connection getConnection(String url,String username,String password){
        try {
            System.out.println("yaratılan nesne : "+ids);
            connection= DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.connection;
    }





}
