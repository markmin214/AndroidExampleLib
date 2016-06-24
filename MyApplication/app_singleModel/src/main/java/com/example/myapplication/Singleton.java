package com.example.myapplication;

/**
 * Created by markmin on 16/6/24.
 */
public class Singleton {

    private static  final Singleton instance =  new Singleton();

    private Singleton() {

    }

    public  static  Singleton getInstance(){

        return  instance;
    }

}

//在上面的代码中，我们将Singleton的实例被声明成 static 和 final 变量了，
//        在第一次加载类到内存中时就会初始化，所以创建实例本身是线程安全的。
//        但是这种写法有个缺点是它不是一种懒加载模式（lazy initialization），
//        单例会在加载类后一开始就被初始化，即使客户端没有调用 getInstance()方法。