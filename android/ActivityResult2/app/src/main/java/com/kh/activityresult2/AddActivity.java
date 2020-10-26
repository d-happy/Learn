package com.kh.activityresult2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.nio.Buffer;

public class AddActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getIntent() 가능
                /*int num1 = getIntent().getIntExtra("num1", 0);
                int num2 = getIntent().getIntExtra("num2", 0);
                int add = num1 + num2;*/

                Intent intent = getIntent(); //MainActivity 에서 설정한 인텐트
                int[] nums = getIntent().getIntArrayExtra("nums");
                int add = nums[0] + nums[1];

                //가져오는 intent-Get, 보내는 intent-Set 따로
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                intent2.putExtra("add", add);
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }

}//AddActivity