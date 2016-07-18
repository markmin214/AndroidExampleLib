package com.example.myapplication;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class CustomCametaActivity extends Activity implements SurfaceHolder.Callback {
    private Button btnCapture;
    private Button btnSwitchCamera;
    private SurfaceView svCamera;
    SurfaceHolder surfaceHolder;
    Camera mCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_cameta);

        initVIew();


    }

    private void initVIew() {
        btnCapture = (Button) findViewById(R.id.btn_capture);
        btnSwitchCamera = (Button) findViewById(R.id.btn_switch_camera);
        svCamera = (SurfaceView) findViewById(R.id.sv_camera);
        surfaceHolder = svCamera.getHolder();
        surfaceHolder.addCallback(this);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


   private Camera getCamera() {
       Camera c = null;

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
           c = Camera.open(0);
       } else {
           c = Camera.open();
       }
       return c;
    }
/*这里需要注意下这个方法camera.setDisplayOrientation(90)，通过这个方法，我们可以调整摄像头的角度，不然默认是横屏，*/
    private void setStartPreview(Camera camera, SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(holder);
            camera.setDisplayOrientation(90);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void releaseCamera(Camera camera) {
        if (camera  != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setStartPreview(mCamera,holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
      mCamera.stopPreview();
        setStartPreview(mCamera,holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
releaseCamera(mCamera);
    }
}
