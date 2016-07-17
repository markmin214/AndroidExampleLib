package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends Activity {

    private Button btnGet;
    private ImageView ivShow;
    private String mFilePath="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String tempPath = Environment.getExternalStorageDirectory().getPath();
        mFilePath = tempPath + "/" + "test1.png";

        ivShow = (ImageView) findViewById(R.id.iv_show);
        btnGet = (Button) findViewById(R.id.btn_get);


        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


                Uri photoUrl = Uri.fromFile(new File(mFilePath));
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUrl);

                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Bitmap bitmap = null;
                FileInputStream fi = null;
                try {
                     fi = new FileInputStream(mFilePath);
                    bitmap = BitmapFactory.decodeStream(fi);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    if (fi!= null) {
                        try {
                            fi.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                ivShow.setImageBitmap(bitmap);
            }
        }
    }
}
