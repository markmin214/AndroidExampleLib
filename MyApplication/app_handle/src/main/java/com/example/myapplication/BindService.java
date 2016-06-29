package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BindService extends Service {
    private  DownLoadService iBinder = new DownLoadService() ;

    public BindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return iBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }



    public  class DownLoadService extends Binder {

        DownLoadService() {

        }


        public String getSerString() {
            return "Service String";
        }

    }

}
