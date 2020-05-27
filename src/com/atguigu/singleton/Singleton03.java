package com.atguigu.singleton;

//懒汉式（线程不安全）
public class Singleton03 {

    private static Singleton03 instance;

    private Singleton03(){

    }

    public static Singleton03 getInstance(){
        if(instance == null){
            instance = new Singleton03();
        }
        return instance;
    }

    public static void main(String[] args) {

        //非线程安全方式
        for(int i=0; i<20; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-" + Singleton03.getInstance().hashCode());
            },"thread-" + i).start();
        }

    }

}
