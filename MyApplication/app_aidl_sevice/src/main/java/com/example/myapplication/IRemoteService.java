package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class IRemoteService extends Service {

    private IBinder iBinder = new IAddAidlInterface.Stub(){
        @Override
        public int add(int a, int b) throws RemoteException {
            return a+b;
        }
    };

    public IRemoteService() {

    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return iBinder;
    }
}
