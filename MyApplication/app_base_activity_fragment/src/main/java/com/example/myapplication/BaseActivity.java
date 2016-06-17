package com.example.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseActivity extends FragmentActivity {


    protected abstract Fragment createFragment();



    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutRsid());
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fm.beginTransaction()
                    .add(R.id.fragment_container, createFragment())
                    .commit();
        }


    }

    private int getLayoutRsid() {
        return R.layout.activity_main;
    }
}
