package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int MESSAGE_NEW_BOOK_ARRIVED = 1;

    IBookManager bookManager;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MESSAGE_NEW_BOOK_ARRIVED) {
                Log.i(TAG,"11 mylog: "+ msg.obj);
            }

        }
    };


    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
             bookManager = IBookManager.Stub.asInterface(service);
            try {
                bookManager.addBook(new Book(12,"client add book "));
                bookManager.registerListener(arrivedListener);
                List<Book> books = bookManager.getBookList();
                Log.i("MainActivity ", "11 mylog list :  " + books.toString());

            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    private IOnNewBookArrivedListener arrivedListener =
            new IOnNewBookArrivedListener.Stub() {

                @Override
                public void onNewBookArrived(Book newBook) throws RemoteException {
                    mHandler.obtainMessage(MESSAGE_NEW_BOOK_ARRIVED,newBook).sendToTarget();
                }


            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        unbindService(connection);
        try {
            bookManager.unregisterListener(arrivedListener);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.onDestroy();


    }
}
