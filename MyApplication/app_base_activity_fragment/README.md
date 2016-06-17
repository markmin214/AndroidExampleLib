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


