#ava反射

[Java深度历险](http://www.infoq.com/cn/articles/cf-java-reflection-dynamic-proxy)

1.通俗地说,反射机制就是可以把一个类,类的成员(函数,属性),当成一个对象来操作,
也就是说,类,类的成员,我们在运行的时候还可以动态地去操作他们

2.使用反射的一个最大的弊端是性能比较差。相同的操作，用反射API所需的时间大概比直接的使用要慢一两个数量级。不过现在的JVM实现中，反射操作的性能已经有了很大的提升。

3.只要有了java.lang.Class类 的对象，就可以通过其中的方法来获取到该类中的构造方法、域和方法。对应的方法分别是getConstructor、getField和getMethod。这三个方法还有相应的getDeclaredXXX版本，区别在于getDeclaredXXX版本的方法只会获取该类自身所声明的元素，而不会考虑继承下来的。Constructor、Field和Method这三个类分别表示类中的构造方法、域和方法。


