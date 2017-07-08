package com.example.hp796.myapplication.CustomViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class LearningViews extends View{
    private RectF rect;
    private Paint paint;
    private int mdefaultSize =200;
    public LearningViews(Context context) {
        super(context);
        initView(null);
    }

    public LearningViews(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public LearningViews(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    public LearningViews(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(attrs);
    }

    private void initView(AttributeSet attributeSet){
        rect=new RectF();
        rect.left=10;
        rect.top=10;
        rect.right=10+mdefaultSize;
        rect.bottom=10+mdefaultSize;
        paint= new Paint();
        paint.setColor(Color.RED);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(rect,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value=super.onTouchEvent(event);
        if(event.getAction()==MotionEvent.ACTION_DOWN){
              return true;
        }else{
        if(event.getAction()==MotionEvent.ACTION_MOVE){
            if(event.getX()>rect.left&&event.getX()<rect.right){
                if(event.getY()>rect.top&&event.getY()<rect.bottom) {
                    rect.left=event.getX()-5;
                    rect.right=rect.left+200;
                    rect.top=event.getY()+5;
                    rect.bottom=rect.top-200;
                    postInvalidate();
                    return true;
                }
        }}}
        return value;
    }
}
