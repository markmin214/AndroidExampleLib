package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DrawPaintView paintView = new DrawPaintView(this);
//        setContentView(paintView);

        setContentView(R.layout.sample_bulls_eye_view);
    }
}
