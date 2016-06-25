package com.example.myapplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by markmin on 16/6/25.
 */
public class reflection {



    public static String norMalMethod() {
        MyClass myClass = new MyClass(10);
        myClass.increace(5);
        String  printStr = "Normal : "+ myClass.conut;
        return  printStr;
    }

    public static String reflectMethod() {
        String   printStr = null;
        try {
            //Class<?> class1 = Class.forName("com.example.myapplication.MyClass");
           // Constructor<?>[] constructors = MyClass.class.getConstructors();
          ///  MyClass refMyClass = (MyClass) constructors[1].newInstance(100);

            //创建对象
            Constructor constructor = MyClass.class.getConstructor(int.class);
            MyClass reflectMyClass = (MyClass) constructor.newInstance(100);

            //获取方法
            Method method = MyClass.class.getMethod("increace", int.class);
            //调用方法
            method.invoke(reflectMyClass, 500);

            //获取域
            Field field = MyClass.class.getField("conut");
            int refCount = field.getInt(reflectMyClass);

            printStr = "Reflection " + refCount;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  printStr;
    }


}
