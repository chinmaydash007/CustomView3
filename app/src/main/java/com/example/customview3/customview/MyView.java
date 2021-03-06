package com.example.customview3.customview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview3.customview.MyShape;

public class MyView extends View {

    MyShape myShape;
    float ratioRadius;
    int progress;

    public MyView(Context context) {
        super(context);
        initMyView();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMyView();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initMyView();
    }

    public void initMyView(){
        myShape = new MyShape();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

        if((w==0) || (h==0)){
            return;
        }

        float x = (float)w/2.0f;
        float y = (float)h/2.0f;
        float radius;
        if(w > h){
            radius = h * ratioRadius;
        }else{
            radius = w * ratioRadius;
        }

        myShape.setCircle(x, y, radius, Direction.CCW,progress);
        canvas.drawPath(myShape.getPath(), myShape.getPaint());
    }

    public void setShapeRadiusRatio(float ratio,int progress){
        ratioRadius = ratio;
        this.progress=progress;;
    }

}