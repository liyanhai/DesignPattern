package com.atguigu.singleton;

//懒汉式 非线程安全
public class Singleton05 {

    private static Singleton05 instance;
    private Singleton05(){

    }
    public static Singleton05 getInstance(){
        if(instance == null){
            synchronized (Singleton05.class){
                instance = new Singleton05();
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        //非线程安全方式
        for(int i=0; i<10; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-" + Singleton05.getInstance().hashCode());
            },"thread-" + i).start();
        }
    }
}
