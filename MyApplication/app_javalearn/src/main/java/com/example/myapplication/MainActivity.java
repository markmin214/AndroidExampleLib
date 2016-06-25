package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bnShow;
    private TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvShow = (TextView) findViewById(R.id.tv_show);
        bnShow = (Button) findViewById(R.id.bn_show);
        bnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aa = reflection.norMalMethod();
                String bb = reflection.reflectMethod();
                tvShow.setText(aa);
                tvShow.append(bb);
            }
        });

    }
}
