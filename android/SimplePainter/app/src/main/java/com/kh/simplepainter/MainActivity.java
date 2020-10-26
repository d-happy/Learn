package com.kh.simplepainter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int indexFigure = 1;
    final int line = 1;
    final int react = 4;
    final int circle = 100;

    int indexColor = 10;
    final int red = 10;
    final int green = 20;
    final int blue = 30;

    float startX, startY, stopX, stopY;

    Figure figure = new Figure(startX, startY, stopX, stopY, indexFigure, indexColor);
    ArrayList<Figure> figureList = new ArrayList<Figure>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PaintView(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemLine :
                indexFigure = line;
                break;
            case R.id.itemReact :
                indexFigure = react;
                break;
            case R.id.itemCircle :
                indexFigure = circle;
                break;
            case R.id.itemRed :
                indexColor = red;
                break;
            case R.id.itemGreen :
                indexColor = green;
                break;
            case R.id.itemBlue :
                indexColor = blue;
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class Figure {

        float startX = 0;
        float startY = 0;
        float stopX = 0;
        float stopY = 0;
        int indexFigure = 0;
        int indexColor = 0;

        public Figure(float startX, float startY, float stopX, float stopY, int indexFigure, int indexColor) {
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.indexFigure = indexFigure;
            this.indexColor = indexColor;
        }

        @Override
        public String toString() {
            return "Figure [startX=" + startX + ", startY=" + startY + ", "
                    + "stopX=" + stopX + ", stopY=" + stopY
                    + ", indexFigure=" + indexFigure + ", indexColor=" + indexColor + "]";
        }

        public float getStartX() {
            return startX;
        }

        public float getStartY() {
            return startY;
        }

        public float getStopX() {
            return stopX;
        }

        public float getStopY() {
            return stopY;
        }

        public int getIndexFigure() {
            return indexFigure;
        }

        public int getIndexColor() {
            return indexColor;
        }

    }//Figure

    class PaintView extends View {

        public PaintView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            //switch 가능
            for (Figure figure : figureList) {
                if (figure.getIndexColor() == red) {
                    paint.setColor(Color.RED);
                } else if (figure.getIndexColor() == green) {
                    paint.setColor(Color.GREEN);
                } else if (figure.getIndexColor() == blue) {
                    paint.setColor(Color.BLUE);
                }

                if (figure.getIndexFigure() == line) {
                    canvas.drawLine(figure.startX, figure.startY, figure.stopX, figure.stopY, paint);
                } else if (figure.getIndexFigure() == react) {
                    canvas.drawRect(figure.startX, figure.startY, figure.stopX, figure.stopY, paint);
                } else if (figure.getIndexFigure() == circle) {
                    canvas.drawCircle(figure.startX, figure.stopY, (figure.stopX - figure.startX)/2, paint);
                }
            }//for

            if (indexColor == red) {
                paint.setColor(Color.RED);
            } else if (indexColor == green) {
                paint.setColor(Color.GREEN);
            } else if (indexColor == blue) {
                paint.setColor(Color.BLUE);
            }

            if (indexFigure == line) {
                canvas.drawLine
                        (startX, startY, stopX, stopY, paint);
            } else if (indexFigure == react) {
                canvas.drawRect
                        (startX, startY, stopX, stopY, paint);
            } else if (indexFigure == circle) {
                double g = Math.pow(stopX-startX, 2); //제곱
                double h = Math.pow(stopY-startY, 2);
                double f = g + h;
                float y = (float)Math.sqrt(f); //루트

                canvas.drawCircle
                        (startX, stopY, y, paint);
            }

        }//onDraw

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN :
                    startX = event.getX();
                    startY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE :
                    stopX = event.getX();
                    stopY = event.getY();
                    invalidate();//무효화하다 -> onDraw() 실행
                    break;
                case MotionEvent.ACTION_UP :
                    figure = new Figure(startX, startY, stopX, stopY, indexFigure, indexColor);
                    figureList.add(figure);
                    break;
            }
            return true;
        }
    }//PaintView

}//MainActivity