#TabLayout 使用

1.布局

        <android.support.design.widget.TabLayout android:id="@+id/tabs"
            android:layout_width="match_parent" android:layout_height="wrap_content" />


2. 设置FragmentPagerAdapter 适配器

       TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
             tabLayout.setupWithViewPager(mViewPager);

        public class SectionsPagerAdapter extends FragmentPagerAdapter