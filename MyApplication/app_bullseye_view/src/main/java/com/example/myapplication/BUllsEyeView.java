package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by markmin on 16/7/12.
 */
public class BUllsEyeView extends View {
    private  Point mCenterP;
    private  Paint mPaint;
    private float mRadius;

    public BUllsEyeView(Context context) {
        this(context, null);
    }

    public BUllsEyeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BUllsEyeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);

        mCenterP = new Point();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int with;
        int height;
        int contentWith = 100;
        int contentHeight = 100;
        with = getMeasurement(widthMeasureSpec,contentWith);
        height = getMeasurement(heightMeasureSpec,contentHeight);
        setMeasuredDimension(with,height);
    }

    private int getMeasurement(int measureSpec, int contentSize) {
        switch (MeasureSpec.getMode(measureSpec)) {
            case MeasureSpec.AT_MOST:
                return Math.min(measureSpec, contentSize);

            case MeasureSpec.UNSPECIFIED:
                return contentSize;

            case MeasureSpec.EXACTLY:
                return MeasureSpec.getSize(measureSpec);
            default:
                return 0;

        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w!=oldw  || h!=oldh) {
            mCenterP.x = w/2;
            mCenterP.y = h/2;
            mRadius = Math.min(mCenterP.x, mCenterP.y);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenterP.x,mCenterP.y,mRadius,mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mCenterP.x,mCenterP.y,mRadius*0.8f,mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(mCenterP.x,mCenterP.y,mRadius*0.6f,mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mCenterP.x,mCenterP.y,mRadius*0.4f,mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenterP.x,mCenterP.y,mRadius*0.1f,mPaint);

    }
}
