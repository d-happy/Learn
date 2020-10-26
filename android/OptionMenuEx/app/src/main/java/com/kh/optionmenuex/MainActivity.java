package com.kh.optionmenuex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLayout;
    Button myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = findViewById(R.id.myLayout);
        myBtn = findViewById(R.id.myBtn);
    }

    //옵션 메뉴 생성시
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //전개자 얻기, 전개자 객체로 메뉴 전개 (메뉴~ 을 메모리에 올리기)
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu); //R.id 격
        return true;
    }

    //메뉴 아이템 선택시
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemRed :
                myLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen :
                myLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue :
                myLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itemRotate :
                myBtn.setRotation(myBtn.getRotation() + 10);
                break;
            case R.id.itemScale :
                myBtn.setScaleX(myBtn.getScrollX() * 2);
                myBtn.setScaleY(myBtn.getScaleY() * 2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}//class