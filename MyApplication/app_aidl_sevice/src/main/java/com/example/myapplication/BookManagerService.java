package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookManagerService extends Service {

    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<Book>();

    private CopyOnWriteArrayList<IOnNewBookArrivedListener> listeners =
            new CopyOnWriteArrayList<IOnNewBookArrivedListener>();
    private RemoteCallbackList<IOnNewBookArrivedListener> cbListeners =
            new RemoteCallbackList<>();
    private AtomicBoolean mIsServiceDestoryed = new AtomicBoolean(false);


    private final IBookManager.Stub mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            synchronized (mBookList) {
                return mBookList;

            }
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (mBookList) {
                if (!mBookList.contains(book)) {
                    mBookList.add(book);
                }
            }
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
            if (!listeners.contains(listener)) {
                listeners.add(listener);
                cbListeners.register(listener);
            }
        }

        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
            if (listeners.contains(listener)) {
                listeners.remove(listener);
                cbListeners.unregister(listener);
            }
        }
    };

    public BookManagerService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1,"Book 1"));
        mBookList.add(new Book(2,"Book 2"));
        updataBook();
    }

    private void updataBook() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!mIsServiceDestoryed.get()) {
                    try {
                        Thread.sleep(5000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                int bookid = mBookList.size()+1;
                    Book newbook = new Book(bookid, "NewBOOK#" + bookid);
                    try {
                        onNewBookArrived(newbook);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

    private void onNewBookArrived(Book newbook) throws RemoteException {
        mBookList.add(newbook);
        for (int i=0;i<listeners.size();i++) {
            IOnNewBookArrivedListener l = listeners.get(i);
            l.onNewBookArrived(newbook);
        }

        final int N = cbListeners.beginBroadcast();
        for (int i = 0; i<N; i++) {
            IOnNewBookArrivedListener l  = cbListeners.getBroadcastItem(i);
            l.onNewBookArrived(newbook);
        }
        cbListeners.finishBroadcast();

    }

    @Override
    public void onDestroy() {
        mIsServiceDestoryed.set(true);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


}
