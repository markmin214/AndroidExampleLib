package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HelloJni extends AppCompatActivity {

    static {
        System.loadLibrary("hello-jni");
    }

    public native String  stringFromJNI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv_showstring);
        //textView.setText(stringFromJNI());
    }
}
