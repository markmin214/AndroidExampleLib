package com.example.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BindServiceActivity extends AppCompatActivity {

    private TextView tvShow;
    private Button bnButton1;
    BindService.DownLoadService downSer = null;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downSer = (BindService.DownLoadService) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShow = (TextView) findViewById(R.id.tv_show);
        bnButton1 = (Button) findViewById(R.id.bn_button1);

        bnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BindServiceActivity.this, BindService.class);
                bindService(intent, conn, BIND_AUTO_CREATE);
//              unbindService(conn);
                if (downSer != null) {
                    tvShow.setText(downSer.getSerString());
                }

            }
        });

    }

}
