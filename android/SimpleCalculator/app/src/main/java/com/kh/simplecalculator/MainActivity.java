package com.kh.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editNum1, editNum2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        setListeners();
    }

    private void setListeners() {
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        txtResult.setOnClickListener(this);
    }

    private void findview() {
        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        txtResult = findViewById(R.id.txtResult);
    }

    @Override
    public void onClick(View v) {

        String strNum1 = editNum1.getText().toString();
        String strNum2 = editNum2.getText().toString();
        int num1 = 0;
        int num2 = 0;
        try {
            num1 = Integer.parseInt(strNum1);
            num2 = Integer.parseInt(strNum2);
        } catch (NumberFormatException e) {
            Log.e("mytag", e.getMessage());
            Toast.makeText(MainActivity.this, "숫자를 입력해주세요",
                    Toast.LENGTH_LONG).show();
            //num1,2가 숫자 아니면 "~" 메세지 출력
        }

        int result = 0;
        if (v == btnAdd) {
            Log.d("mytag", "더하기");
            result = num1 + num2;
        } else if (v == btnSub) {
            Log.d("mytag", "빼기");
            result = num1 - num2;
        } else if (v == btnMul) {
            Log.d("mytag", "곱하기");
            result = num1 * num2;
        } else if (v == btnDiv) {
            Log.d("mytag", "나누기");
            result = num1 / num2;
        }

        txtResult.setText("계산결과 :" + result);
    }

}//class