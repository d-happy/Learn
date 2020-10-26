package com.kh.activityresult2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //onCreate()에서 final int ~ || 필드 상수로 설정

                Intent intent = getIntent(); ////MainActivity 에서 설정한 인텐트
                int num1 = intent.getIntExtra("num1", 0);
                int num2 = intent.getIntExtra("num2", 0);
                int sub = num1 - num2;

                //가져오는 intent-Get, 보내는 intent-Set 따로
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                intent2.putExtra("sub", sub);
                setResult(RESULT_OK, intent2);
                //Log.d("mytag", String.valueOf(sub));
                finish();
            }
        });
    }

}//SubActivity