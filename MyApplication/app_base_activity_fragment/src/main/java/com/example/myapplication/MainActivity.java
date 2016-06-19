package com.example.myapplication;

import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
//        return new BlankFragment();
        return new FragmentMaster().newInstance0();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }
}
