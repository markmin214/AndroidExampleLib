package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNum1;
    private EditText etNum2;
    private Button btAdd;
    private TextView tvShow;
IAddAidlInterface iAddAidlInterface = null;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
         iAddAidlInterface = (IAddAidlInterface) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNum1 = (EditText) findViewById(R.id.et_num1);
        etNum2 = (EditText) findViewById(R.id.et_num2);
        btAdd = (Button) findViewById(R.id.bt_add);
        btAdd.setOnClickListener(this);
        tvShow = (TextView) findViewById(R.id.tv_show);

         bindMyservice();

    }

    private void bindMyservice() {

        Intent intent = new Intent();
        intent.setAction("com.example.myapplication.IRemoteService");
        intent.setComponent(new ComponentName("com.example.myapplication","com.example.myapplication.IRemoteService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);

    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());
        int sum = num1+num2;
        tvShow.setText(String.valueOf(sum));
    }



}
