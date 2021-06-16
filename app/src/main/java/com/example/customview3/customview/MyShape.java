package com.example.customview3.customview;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

public class MyShape {

    private Paint paint;
    private Path path;

    public MyShape() {
        paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);

        path = new Path();
    }

    public void setCircle(float x, float y, float radius, Path.Direction dir, int progress) {
        path.reset();
        paint.setAlpha((int) (2.55) * progress);
        Log.d("mytag", progress + " ");
        path.addCircle(x, y, radius, dir);
    }

    public Path getPath() {
        return path;
    }

    public Paint getPaint() {
        return paint;
    }

}
