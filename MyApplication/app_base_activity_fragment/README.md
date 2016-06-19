>[Blog](http://blog.csdn.net/lmj623565791/article/details/42628537)
#BaseActivity
 1.mainactivity xml

      <FrameLayout
            android:id="@id/fragment_container"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

2.mainactivity 实现 createFragment

    FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);
            if (fragment == null) {
                fm.beginTransaction()
                        .add(R.id.fragment_container, createFragment())
                        .commit();
            }


3.Fragment间的数据传递
启动的时候调用了Fragment.setTargetFragment
传递的时候通过getTargetFragment().onActivityResult
获取的时候还是在onActivityResult