package com.example.app_activity_launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvShowInfo;
    private Button bnOpenFirst;
    private Button bnOpenSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         getSupportActionBar().setTitle("FirstActivity");
//        getActionBar().setTitle("MainActivity");

        tvShowInfo = (TextView) findViewById(R.id.tv_show_info);
        tvShowInfo.setText("CUrrent :  " + this.toString() +
                         "\n Taskid :  "+ getTaskId());


        bnOpenFirst = (Button) findViewById(R.id.bn_open_first);
        bnOpenFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//singleTask
                startActivity(intent);
            }
        });
        bnOpenSecond = (Button) findViewById(R.id.bn_open_second);
        bnOpenSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
