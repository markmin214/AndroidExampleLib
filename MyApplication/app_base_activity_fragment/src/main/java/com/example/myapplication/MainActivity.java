package com.example.myapplication;

import android.support.v4.app.Fragment;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {

        return new BlankFragment();

    }
}
