package com.example.customview3.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview3.R;

import java.util.Random;

public class SquareView extends View {
    Paint paint = new Paint();
    Rect rect = new Rect();
    Handler handler = new Handler(Looper.getMainLooper());

    Paint circlePaint = new Paint();


    boolean isEnabled = true;

    int square_color;
    int square_size;

    int circle_color;
    int circle_radius;


    public SquareView(Context context) {
        super(context);
        init(context, null);
    }

    public SquareView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public SquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    void init(Context context, AttributeSet attributeSet) {
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);


        if (attributeSet != null) {
            TypedArray typedArrays = getContext().obtainStyledAttributes(attributeSet, R.styleable.SquareView);
            square_color = typedArrays.getColor(R.styleable.SquareView_square_color, Color.RED);
            square_size = typedArrays.getDimensionPixelSize(R.styleable.SquareView_square_size, 300);
            circle_color = typedArrays.getColor(R.styleable.SquareView_circle_color, Color.BLUE);
            circle_radius = typedArrays.getDimensionPixelSize(R.styleable.SquareView_circle_radius, 100);
            paint.setColor(square_color);
            circlePaint.setColor(circle_color);

            rect.right = square_size;
            rect.bottom = square_size;


            typedArrays.recycle();

        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(rect, paint);

        float cx = getWidth() - circle_radius - 50f;
        float cy = rect.top + ((float) rect.height() / 2);


        canvas.drawCircle(cx, cy, circle_radius, circlePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }

    public void swapColor() {
        if (paint.getColor() == Color.RED) {
            paint.setColor(Color.GREEN);
        } else {
            paint.setColor(Color.RED);
        }
        postInvalidate();
    }

    public void setRandomColor() {
        if (isEnabled) {
            int argb = Color.argb(255, new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));
            paint.setColor(argb);
            postInvalidate();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setRandomColor();
                }
            }, 100);
        }
    }


}
