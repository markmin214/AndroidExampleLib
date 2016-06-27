package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvShow;
    private Button bnButton1;

    Handler mMainHandle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x123:
                    tvShow.setText("MainHandle   0x123");// main updata UI
                    break;
                case 0x1:
                    tvShow.setText((CharSequence) msg.obj);// main updata UI
                    break;
                case 0x2:
                    tvShow.setText("MainHandle   0x123");// main updata UI
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShow = (TextView) findViewById(R.id.tv_show);
        bnButton1 = (Button) findViewById(R.id.bn_button1);

        mMainHandle.sendEmptyMessage(0x123);

        final ChildThread childThread1 = new ChildThread();
        childThread1.start();

bnButton1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        childThread1.childHandler1.sendEmptyMessage(0x11);
    }
});



    }


   public class  ChildThread extends Thread{

       Handler childHandler1 = null;
       @Override
       public void run() {

           Looper.prepare();
            childHandler1 = new Handler(){
               @Override
               public void handleMessage(Message msg) {
                   // spent many time
                   try {
                       sleep(1000);

                       Message childmasg1 = new Message();
                       childmasg1.obj = "From ChildThread send handle";
                       childmasg1.what = 0x11;

                       mMainHandle.sendMessage(childmasg1);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           };
           Looper.loop();
       }
   }
}
