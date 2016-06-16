#activity四种启动模式
##设置方式，
1.class中 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
2.xml中   android:launchMode="singleTop"
##standard 模式
##系统默认
 每当启动一个新的活动，它就会在 Task 栈中入栈，并处于栈顶位置。
 对于该模式下，系统不会在乎是否这个活动已经在栈中，每次启动都会创建该活动的一个新的实例

 当我们按返回键的时候，弹出栈顶的activity实例，然后在顶部activity下面的Activity显示出来，占据栈顶！

##Activity SingleTask 启动模式
##栈内复用
 因为堆栈中存在MainActivity实例，所以我们不会再去新创建一个新的MainActivity实例，而是把存在堆栈底部的MainActivity实例拿出来使用，那么问题来了，怎么拿出来？？
 很暴力的，MainActivity直接把在他上面的BActivity 弹出了堆栈，自己占据栈顶！此时，堆栈中只有MainActivity一个实例，所以按返回键，就自然退出程序了！

##Activity SingleTop 启动模式
##栈顶复用
SingleTop 模式下，启动的实例如果存在栈顶，ActivityManager并不会新建一个实例，而是选 择复 用原来的实例来保持singleTop中的唯一性，只会去调用onNewIntent方法如何实例不在栈顶，那么会再次创建一个实例，堆栈中会存在两个相同的实例。

##Activity SingleInstance启动模式
##单实例
这种启动模式比较特殊，因为它会启用一个新的栈结构，将Acitvity放置于这个新的栈结构中，并保证不再有其他Activity实例进入

