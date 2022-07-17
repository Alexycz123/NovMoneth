package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-04-10:49
*/

public class SingleObject {

    // 创建SingleObject 的一个对象
    private static SingleObject instance=new SingleObject();

    // 让构造函数为private，这样该类就不会实例化
    private  SingleObject(){

    }
    // 获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("hello world");
    }
}
