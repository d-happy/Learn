package com.kh.paintex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new PaintView(this));
    }

    class PaintView extends View {

        public PaintView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //canvas : 도화지, canvas 가 그림
            Paint paint = new Paint(); //붓
            //paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            canvas.drawLine(100, 100, 300 , 300, paint);

            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(5);
            canvas.drawRect(10, 310, 310, 510, paint);

            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(10, 530, 310, 730, paint);

            paint.setColor(Color.MAGENTA);
            paint.setStrokeWidth(3);
            canvas.drawCircle(160, 850, 100, paint);

            String str = "Hello 배고파 배고파 배고파";
            paint.setTextSize(30);
            paint.setStrokeWidth(1);
            canvas.drawText(str,100, 1000, paint);
        }
    }

}//class