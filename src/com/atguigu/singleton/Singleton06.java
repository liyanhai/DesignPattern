package com.atguigu.singleton;

//懒汉式 线程安全
public class Singleton06 {

    /**
     * instance = new Singleton06();
     * 1、分配内存
     * 2、instance 指向对象实例
     * 3、对象初始化
     * 2、3步由于JVM优化，可能发生指令重排序。所以 volatile 能禁止指令重排序
     */
    private static volatile Singleton06 instance;

    private Singleton06(){

    }

    public static Singleton06 getInstance(){
        if(instance == null){
            synchronized (Singleton06.class){
                if(instance == null){
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //非线程安全方式
        for(int i=0; i<10; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-" + Singleton06.getInstance().hashCode());
            },"thread-" + i).start();
        }
    }

}
