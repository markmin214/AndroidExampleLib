package com.example.appsimplecursoradapter;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends Activity {
    SQLiteDatabase db;
    Button bn = null;
    ListView listView;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = SQLiteDatabase.openOrCreateDatabase(
                this.getFilesDir().toString()
                        + "/mydata.db", null);


        listView = (ListView) findViewById(R.id.ls_show);

        bn = (Button) findViewById(R.id.bt_insert);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ((EditText) findViewById(R.id.title))
                        .getText().toString();
                String content = ((EditText) findViewById(R.id.content))
                        .getText().toString();
                try {
                    insetAndShowData(title,content);
                } catch (SQLiteException se) {
                    db.execSQL("create table BOOK(_id integer"
                            + " primary key autoincrement,"
                            + " news_title text,"
                            + " news_content text)");

                    insetAndShowData(title,content);

                }



            }
        });

    }

    private void insetAndShowData(String title, String content) {

        db.execSQL("insert into BOOK values(null, ?, ?)",new String[]{title,content});


        Cursor cursor = db.rawQuery("select * from BOOK",null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MainActivity.this,
                R.layout.layout_list,
                cursor,
                new String[]{"news_title","news_content"},
                new int[]{R.id.item_title,R.id.item_content},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null && db.isOpen()) {
            db.close();
        }

    }
}
