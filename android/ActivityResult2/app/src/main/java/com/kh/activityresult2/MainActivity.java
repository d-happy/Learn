package com.kh.activityresult2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText edtNum1, edtNum2;
    Button btnAdd, btnSub;
    final int REQUEST_CODE_ADD = 1001;
    final int REQUEST_CODE_SUB = 1002;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_ADD :
                Log.d("mytag", "add");
                int add = data.getIntExtra("add", 0);
                Toast.makeText(this, String.valueOf(add), Toast.LENGTH_SHORT).show();
                break;
            case REQUEST_CODE_SUB :
                Log.d("mytag", "sub");
                int sub = data.getIntExtra("sub", 0);
                Toast.makeText(this, String.valueOf(sub), Toast.LENGTH_SHORT).show();
                break;
            //data.getIntExtra() 똑같이, case 마다 Toast-str 다르게 해서
            //switch 전 후로 반복 부분 빼놓기
        }
    }

    @Override
    public void onClick(View v) {
        num1 = Integer.parseInt(edtNum1.getText().toString());
        num2 = Integer.parseInt(edtNum2.getText().toString());
        int[] nums = {num1, num2}; //배열로 1번에 보내기, 가능

        Intent intent = null;
        int REQUEST_CODE = 0;

        if (v == btnAdd) {
            intent = new Intent(getApplicationContext(), AddActivity.class);
            intent.putExtra("nums", nums);
            //startActivityForResult(intent, REQUEST_CODE_ADD);
            REQUEST_CODE = REQUEST_CODE_ADD;
        } else if (v == btnSub) {
            intent = new Intent(getApplicationContext(), SubActivity.class);
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);
            //startActivityForResult(intent, REQUEST_CODE_SUB);
            REQUEST_CODE = REQUEST_CODE_SUB;
        }
        startActivityForResult(intent, REQUEST_CODE);
        //중복 부분은 하나로 하고, 다를 때 변수로 변경
    }

}//MainActivity