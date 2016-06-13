package com.example.application_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MyDatabaseHelper dbHelper;
    SQLiteDatabase db;
    private TextView tvShowContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         dbHelper = new MyDatabaseHelper(this,"Book.db",null,1);


        tvShowContent = (TextView) findViewById(R.id.tv_show_content);


          findViewById(R.id.tv_create).setOnClickListener(this);
          findViewById(R.id.tv_insert).setOnClickListener(this);
          findViewById(R.id.tv_updata).setOnClickListener(this);
          findViewById(R.id.tv_delete).setOnClickListener(this);
          findViewById(R.id.tv_query).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        db = dbHelper.getWritableDatabase();

        switch (v.getId()){
            case R.id.tv_create:

            break;
            case R.id.tv_insert:

                ContentValues values = new ContentValues();
                values.put(MyDatabaseHelper.COLUMN_TITLE,"First code");
                values.put(MyDatabaseHelper.COLUMN_PRICE,"66.8");
                db.insert(MyDatabaseHelper.TABLE_NAME, null, values);
                values.clear();
            break;
            case R.id.tv_updata:

                ContentValues valueUpdata = new ContentValues();
                valueUpdata.put(MyDatabaseHelper.COLUMN_PRICE, 88.6);
                db.update(MyDatabaseHelper.TABLE_NAME, valueUpdata,
                        MyDatabaseHelper.COLUMN_TITLE + "=?", new String[]{"First code"});

            break;
            case R.id.tv_delete:

                db.delete(MyDatabaseHelper.TABLE_NAME,
                        MyDatabaseHelper.COLUMN_PRICE + " > ?", new String[]{"80"});
            break;

            case R.id.tv_query:
                getAllData();
                break;

        }
    }

    private void getAllData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                MyDatabaseHelper.COLUMN_ENTRY_ID,
                MyDatabaseHelper.COLUMN_TITLE,
                MyDatabaseHelper.COLUMN_PRICE
        };

        Cursor c = db.query(
                MyDatabaseHelper.TABLE_NAME, projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String title = c.getString(c.getColumnIndex(MyDatabaseHelper.COLUMN_TITLE));
                double price = c.getDouble(c.getColumnIndex(MyDatabaseHelper.COLUMN_PRICE));
                tvShowContent.append("\n Query "+ title +"  price:"+price);

            }
        }
        if (c != null) {
            c.close();
        }

        db.close();
    }
}
