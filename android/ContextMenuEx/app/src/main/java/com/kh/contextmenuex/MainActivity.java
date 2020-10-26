package com.kh.contextmenuex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLayout;
    Button btnBackground, btnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = findViewById(R.id.myLayout);
        btnBackground = findViewById(R.id.btnBackground);
        btnButton = findViewById(R.id.btnButton);

        //컨테스트 메뉴 등록
        registerForContextMenu(btnBackground);
        registerForContextMenu(btnButton);
    }

    //컨테스트 메뉴 생성
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        if (v == btnBackground) {
            inflater.inflate(R.menu.menu_background, menu);
        } else if (v == btnButton) {
            inflater.inflate(R.menu.menu_button, menu);
        }
    }

    //컨테스트 메뉴 선택
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemREd :
                myLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen :
                myLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue :
                myLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itemRotate :
                btnButton.setRotation(btnButton.getRotation() + 10);
                break;
            case R.id.itemScale :
                btnButton.setScaleX(btnButton.getScaleX() * 2);
                btnButton.setScaleY(btnButton.getScaleY() * 2);
                break;
        }
        return true;
    }
}//class