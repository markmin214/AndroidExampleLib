package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by markmin on 16/6/29.
 */
public class BaseActivity  extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
ActivityCollector.addToActivityList(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeFromActivityList(this);
    }
}
