package com.kh.intentextraex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtName, txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);

        Intent intent = getIntent(); //MainActivity 에서 설정한 인텐트
        //get###Extra() : 타입별로 정의되어 있음
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);

        txtName.setText("이름 : "+ name);
        txtAge.setText("나이 : "+ age);
    }
}