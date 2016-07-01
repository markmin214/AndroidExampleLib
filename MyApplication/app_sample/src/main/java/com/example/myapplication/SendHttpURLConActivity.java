package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendHttpURLConActivity extends AppCompatActivity {


    private static final int SHOW_RESPONSE = 0;
    private Button bnSend;
    private TextView tvResponse;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {



        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_http_urlcon);


        bnSend = (Button) findViewById(R.id.bn_send);
        tvResponse = (TextView) findViewById(R.id.tv_response);
  bnSend.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          SengHttpURL();
      }
  });


    }

    private void SengHttpURL() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL uRl = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection) uRl.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream inputStream = connection.getInputStream();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    String line;
                    while((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    Message message = new Message();
                    message.what = SHOW_RESPONSE;
                    message.obj = stringBuilder.toString();
                    handler.sendMessage(message);

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }

            }
        }).start();
    }
}
