package com.kh.toastex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNormal, btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNormal = findViewById(R.id.btnNormal);
        btnCustom = findViewById(R.id.btnCustom);
        btnNormal.setOnClickListener(this);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "일반 토스트", Toast.LENGTH_LONG).show();
                //첫 번째 인자는 현재 프로세스의 Context 정보를 넘겨주고
                //https://lktprogrammer.tistory.com/152
                //-> MainActivity 위에서 Toast 실행되니 MainActivity 를 가리켜야 함
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == btnNormal) {
            Toast.makeText(this, "일반 토스트", Toast.LENGTH_LONG).show();
            //MainActivity 바탕에서 Toast 작동함,
            //MainActivity->View.OnClickListener->onClick(View v), this
            //결국 this 는 MainActivity 가리킴
        } else if (v == btnCustom) {
            //xml 파일을 전개할 전개자 얻기
            LayoutInflater inflater = getLayoutInflater();
            //전개하기
            View toastView = inflater.inflate(R.layout.view_toast, null);
            //토스트 생성
            //Toast toast = Toast.makeText(this, null, Toast.LENGTH_LONG);
            Toast toast = new Toast(this);
            //토스트의 뷰를 설정
            toast.setView(toastView);
            //토스트 보이기
            toast.show();
        }
    }
}//class