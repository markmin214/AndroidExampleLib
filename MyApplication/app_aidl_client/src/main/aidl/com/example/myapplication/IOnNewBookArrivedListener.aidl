// IOnNewBookArrivedListener.aidl
package com.example.myapplication;
import com.example.myapplication.Book;

// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

  void onNewBookArrived(in Book newBook);


}
