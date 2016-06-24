package com.example.myapplication;

/**
 * Created by markmin on 16/6/24.
 */
public class Singleton2 {

 private  volatile static  Singleton2  instance = null;


    private Singleton2() {

    }

    public  static  Singleton2 getInstance(){

        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return  instance;
    }
}

//    双重检查加锁机制在进入getInstance()方法之后，先检查实例是否存在，如果不存在才进入下面的同步块，这是第一重检查。
//        进入同步块过后，再次检查实例是否存在，如果不存在，就在同步的情况下创建一个实例，这是第二重检查。
//        我们在声明Singleton实例时添加了volatile关键字，
// 被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存,从而确保多个线程能正确的处理该变量