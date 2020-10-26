package com.kh.tablacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editNum1, editNum2;
    Button btnDot, btnClear;

    Button[] buttons = new Button[10];
    int[] buttonId = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    String[] nums = new String[buttons.length];

    Button[] btnCalcul = new Button[4];
    int[] btnCalId = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv};

    TextView txtResult;

    double num1;
    double num2;
    double numResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        setListener();
    }

    private void findview() {
        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        txtResult = findViewById(R.id.txtResult);
        btnDot = findViewById(R.id.btnDot);
        btnClear = findViewById(R.id.btnClear);

        for (int i=0; i<btnCalcul.length; i++) {
            btnCalcul[i] = (Button) findViewById(btnCalId[i]);
        }

        for (int i=0; i<buttonId.length; i++) {
            buttons[i] = (Button)findViewById(buttonId[i]);
            nums[i] = buttons[i].getText().toString();
            Log.d("mytag", nums[i]);
        }
    }

    private void setListener() {
        //txtResult.setOnClickListener(this);

        btnDot.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        for (int i=0; i<buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }

        for (int i=0; i<btnCalcul.length; i++) {
            btnCalcul[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        for (int i=0; i<buttons.length; i++) {
            if (v == buttons[i]) {
                if (editNum1.isFocused() == true) {
                    editNum1.append(nums[i]);
                    num1 = Double.parseDouble(editNum1.getText().toString());
                } else if (editNum2.isFocused() == true) {
                    editNum2.append(nums[i]);
                    num2 = Double.parseDouble(editNum2.getText().toString());
                }
            }
        }

        if (v == btnDot) {
            if (editNum1.isFocused() == true) {
                editNum1.append(".");
            } else if (editNum2.isFocused() == true) {
                editNum2.append(".");
            }
        }

        if (v == btnClear) {
            if (editNum1.isFocused() == true) {
                editNum1.setText(null);
            } else if (editNum2.isFocused() == true) {
                editNum2.setText(null);
            }
        }

        for (int i=0; i<btnCalcul.length; i++) {
            if (btnCalcul[i].getText().equals("더하기") && btnCalcul[i] == v) {
                numResult = num1 + num2;
                txtResult.setText("계산결과 : " + String.valueOf(numResult));
            } else if (btnCalcul[i].getText().equals("빼기") && btnCalcul[i] == v) {
                numResult = num1 - num2;
                txtResult.setText("계산결과 : " + String.valueOf(numResult));
            } else if (btnCalcul[i].getText().equals("곱하기") && btnCalcul[i] == v) {
                numResult = num1 * num2;
                txtResult.setText("계산결과 : " + String.valueOf(numResult));
            } else if (btnCalcul[i].getText().equals("나누기") && btnCalcul[i] == v) {
                numResult = num1 / num2;
                txtResult.setText("계산결과 : " + String.valueOf(numResult));
            }
        }//for
    }

}//class