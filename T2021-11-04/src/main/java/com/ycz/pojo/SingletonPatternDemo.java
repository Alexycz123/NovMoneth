package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-04-10:52
*/

public class SingletonPatternDemo {
    public static void main(String[] args) {

//        SingleObject singleObject=new SingleObject();
        //这是不行的
        SingleObject singleObject=SingleObject.getInstance();
        singleObject.showMessage();
        System.out.println(singleObject);

        SingleObject singleObject2=SingleObject.getInstance();
        System.out.println(singleObject2);

    }
}
