package com.example.application_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by markmin on 16/6/13.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "BOOK";
    public static final String COLUMN_ENTRY_ID = "entryid";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CATEGORYID = "cagegoryid";
    public static final String COLUMN_PRICE = "completed";

    public static final String TABLE_NAME2 = "Category";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CODE = "code";



    private static final String CREATE_TABLE
            = "create table "+TABLE_NAME+" ("+
            COLUMN_ENTRY_ID +" integer primary key autoincrement," +
            COLUMN_TITLE +" text," +
            COLUMN_PRICE +" real," +
            COLUMN_CATEGORYID+" integer)"; // version 3 new add

    private static final String CREATE_TABLE2 //version 2 add
            = "create table "+TABLE_NAME2+" ("+
            COLUMN_ENTRY_ID +" integer primary key autoincrement," +
            COLUMN_NAME+" text," +
            COLUMN_CODE+" integer)";


    private static final String CREATE_TABLE1
            = "create table Book (id integer primary key autoincrement, author text, price real)";


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion) {
            case 1:
                db.execSQL(CREATE_TABLE2);
            case 2:
                db.execSQL("alter table "+TABLE_NAME+"add column "+COLUMN_CATEGORYID+" integer");
                default:
        }
    }
}
