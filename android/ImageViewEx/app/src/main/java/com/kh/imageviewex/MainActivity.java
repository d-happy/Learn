package com.kh.imageviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivPuppy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivPuppy = findViewById(R.id.ivPuppy);
    }

    //xml에서 onclick으로 사용하려면 메서드명만 변경, 테스트 용도
    public void show(View v) {
        int intVisible = ivPuppy.getVisibility();
        //View.VISIBLE, View.VISIBLE, View.GONE
        switch (intVisible) {
            case View.VISIBLE :
                ivPuppy.setVisibility(View.INVISIBLE);
                break;
            case View.INVISIBLE :
                ivPuppy.setVisibility(View.VISIBLE);
                break;
        }

    }

    public void show2(View v) {
        ivPuppy.setImageResource(R.drawable.cat);
    }

}//class