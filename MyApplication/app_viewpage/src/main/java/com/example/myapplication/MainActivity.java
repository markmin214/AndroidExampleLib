package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private  ViewPager mViewpager;
    private FrameLayout fragmentContent;
    private Button first;
    private Button second;
    private Button three;


    private List<View> mView;
    private int mCurItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewpager  = (ViewPager) findViewById(R.id.viewpager);
        fragmentContent = (FrameLayout) findViewById(R.id.fragment_content);

        first = (Button) findViewById(R.id.first);
        first.setOnClickListener(this);
        mCurItem = 0;
        first.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

        second = (Button) findViewById(R.id.second);
        second.setOnClickListener(this);

        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(this);




         initViewPager();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first:

                mCurItem = 0;
                break;
            case R.id.second:

                mCurItem = 1;
                break;
            case R.id.three:

                mCurItem = 2;
                break;
        }
        mViewpager.setCurrentItem(mCurItem);
    }
    private void initViewPager() {

        mView = new ArrayList<View>();
        mView.add(LayoutInflater.from(this).inflate(R.layout.layout1,null));
        mView.add(LayoutInflater.from(this).inflate(R.layout.layout2,null));
        mView.add(LayoutInflater.from(this).inflate(R.layout.layout3,null));

        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mView.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mView.get(position);
                 container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mView.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };


        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              resetButotonState();
                switch (position) {
                    case 0:
                        first.setBackgroundColor(getResources()
                                .getColor(android.R.color.holo_blue_bright));
                        break;
                    case 1:
                        second.setBackgroundColor(getResources()
                                .getColor(android.R.color.holo_blue_bright));
                        break;
                    case 2:
                        three.setBackgroundColor(getResources()
                                .getColor(android.R.color.holo_blue_bright));
                        break;
                }
                mCurItem = position;
                mViewpager.setCurrentItem(position);
            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };


        mViewpager.setAdapter(adapter);
        mViewpager.setOnPageChangeListener(listener);
mViewpager.setCurrentItem(mCurItem);
    }

    private void resetButotonState() {
        first.setBackgroundColor(getResources().getColor(android.R.color.background_light));
        second.setBackgroundColor(getResources().getColor(android.R.color.background_light));
        three.setBackgroundColor(getResources().getColor(android.R.color.background_light));

    }



}

