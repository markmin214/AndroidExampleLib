package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class BookManagerActivity extends AppCompatActivity {

    IBookManager bookManager = null;
    List<Book> books = null;


    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bookManager = IBookManager.Stub.asInterface(service);
            try {
                books = bookManager.getBookList();

                Log.i("BookManagerActivityLOG", "Books: " + books.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_manager);

        Intent intent = new Intent();
        intent.setAction("com.example.myapplication.BookManagerService");

        intent.setComponent(new ComponentName("com.example.myapplication","com.example.myapplication.BookManagerService"));

        bindService(intent, conn, Context.BIND_AUTO_CREATE);
//        String str = books.toString();
        String str = "";
        TextView show = (TextView) findViewById(R.id.tv_show);
        show.setText(str);
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (bookManager !=null) {
                    try {

                        List<Book> list = bookManager.getBookList();

                        if (list!=null) {
                            Log.i("BookManagerActivityLOG", "Books 2: " + list.toString());
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }

    @Override
    protected void onDestroy() {
        unbindService(conn);
        super.onDestroy();

    }
}
