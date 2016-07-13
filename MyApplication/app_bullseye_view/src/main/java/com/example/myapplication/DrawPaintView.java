package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by markmin on 16/7/13.
 */
public class DrawPaintView extends View {
    private  Paint mPaint;
private  int mLastX,mLastY;
    private int mCurX,mCurY;

    private Bitmap mBitmap;

    public DrawPaintView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setStrokeWidth(6);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int with = getWidth();
        int height = getHeight();
        if (mBitmap == null) {
            mBitmap = Bitmap.createBitmap(with, height, Bitmap.Config.ARGB_8888);
        }

        Canvas tmpCanvas = new Canvas(mBitmap);
        tmpCanvas.drawLine(mLastX,mLastY,mCurX,mCurY,mPaint);

        canvas.drawBitmap(mBitmap,0,0,mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mLastX = mCurX;
        mLastY = mCurY;

        mCurX = (int) event.getX();
        mCurY = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = mCurX;
                mLastY = mCurY;
                break;
            default:
                break;

        }
        invalidate();
        return  true;

    }
}
