package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by markmin on 16/6/15.
 */
public class LayoutTitle extends LinearLayout {
    public LayoutTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_toptitle, this);
         Button bnBack =(Button) findViewById(R.id.bn_back);
         bnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });

        TextView tvTitle = (TextView) findViewById(R.id.tv_title);

        Button bnSave = (Button) findViewById(R.id.bn_save);

    }
}
