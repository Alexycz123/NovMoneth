package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-04-11:02
*/

public class Singleton {


    private static Singleton instance;
    private Singleton(){

    }

    private static Singleton getInstance(){
        if (instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
