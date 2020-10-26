package com.kh.painttouchex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new PaintView(this));
    }

    class PaintView extends View {

        float startX, startY, stopX, stopY;

        public PaintView (Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            canvas.drawLine(startX, startY, stopX, stopY, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN : //시작, 끝 : ACTION_UP
                    startX = event.getX();
                    startY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE :
                    stopX = event.getX();
                    stopY = event.getY();
                    invalidate();//무효화하다 -> onDraw() 실행
                    break;
            }
            return true;
        }
    }//PaintView

}//MainActivity