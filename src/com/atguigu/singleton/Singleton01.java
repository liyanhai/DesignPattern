package com.atguigu.singleton;

//恶汉式
public class Singleton01 {

    private Singleton01(){}

    private final static Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance(){
        return instance;
    }

    public static void main(String[] args) {

        Singleton01 instance = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
        System.out.println(instance == instance2);
        System.out.println("instance hashCode=" + instance.hashCode());
        System.out.println("instance2 hashCode=" + instance2.hashCode());
    }

}

