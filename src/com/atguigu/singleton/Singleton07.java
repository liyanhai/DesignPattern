package com.atguigu.singleton;

/**
 * 懒汉式 线程安全
 * 当 Singleton07 被装载的时候，并不会导致静态内部类InnerSingleton 被装载，所以是懒加载
 *  而静态内部类在装载的时候又是线程安全的，类的静态属性只有在装载的时候被初始化一次
 */
public class Singleton07 {

    private Singleton07(){

    }

    public static Singleton07 getInstance(){
        return InnerSingleton.INSTANCE;
    }

    private static class InnerSingleton{
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    public static void main(String[] args) {

        //非线程安全方式
        for(int i=0; i<10; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-" + Singleton07.getInstance().hashCode());
            },"thread-" + i).start();
        }

    }

}
