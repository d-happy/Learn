package com.kh.activityresultex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSecond, btnThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecond = findViewById(R.id.btnSecond);
        btnThird = findViewById(R.id.btnThird);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult(intent, 1001);
            }
        });

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivityForResult(intent, 1002);
            }
        });
    }//onCreate

    //새로운 액티비티 실행 중에 종료되면 실행 되는 콜백
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("mytag", requestCode +"");

        switch (requestCode) {
            case 1001 :
                String name = data.getStringExtra("name");
                Toast.makeText(this, name, Toast.LENGTH_LONG).show();
                break;
            case 1002 :
                int age = data.getIntExtra("age", 0);
                Toast.makeText(this, age +"살", Toast.LENGTH_LONG).show();
                break;
        }
    }

}//MainActivity