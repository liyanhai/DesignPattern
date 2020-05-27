package com.atguigu.singleton;

//懒汉式（线程安全）
public class Singleton04 {

    private static Singleton04 instance;
    private Singleton04(){

    }
    public static synchronized Singleton04 getInstance(){
        if(instance == null){
            instance = new Singleton04();
        }
        return instance;
    }

    public static void main(String[] args) {
        //非线程安全方式
        for(int i=0; i<100; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-" + Singleton04.getInstance().hashCode());
            },"thread-" + i).start();
        }
    }

}
