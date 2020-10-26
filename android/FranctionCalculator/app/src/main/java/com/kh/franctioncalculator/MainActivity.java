package com.kh.franctioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editNum1, editNum2;
    Button btnSla, btnDol;

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

    class Fraction {

        Fraction() { }

        double makeFraction(String str) {
            String[] getStr = str.split("/", 2);
            double[] num = new double[2];
            double numDouble;

            if (str.indexOf("/") > -1) {
                for (int i=0; i<getStr.length; i++) {
                    num[i] = Double.parseDouble(getStr[i]);
                }
                numDouble = num[0] / num[1];
            } else {
                numDouble = Double.parseDouble(str);
            }
            return numDouble;
        }

        String presentFraction(double numResult) {
            String numStr = String.valueOf(numResult);

            String[] getNumerator = numStr.split(".", 2);
            String str = getNumerator[1].substring(1);
            int numerator = Integer.parseInt(str);

            int strLength = numStr.length();
            int denominator = (int) Math.pow(10, strLength-2);

            Log.d("tag", numerator +" | "+ denominator +" | "+ strLength);

            int gcd = greatestCommonDivisor(numerator, denominator);

            numerator = numerator / gcd;
            denominator = denominator / gcd;

            String strFraction = "계산결과 : "+ numerator +"/"+ denominator;
            return strFraction;
        }

        int greatestCommonDivisor(int numerator, int denominator) {
            int temp = 1;
            while (temp != 0) {
                temp = denominator % numerator;
                denominator = numerator;
                numerator = temp;
            }
            int gcd = denominator;
            return gcd;
        }

    }//Fraction

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
    }

    private void findView() {
        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        txtResult = findViewById(R.id.txtResult);
        btnSla = findViewById(R.id.btnSla);
        btnDol = findViewById(R.id.btnDol);

        for (int i=0; i<btnCalcul.length; i++) {
            btnCalcul[i] = findViewById(btnCalId[i]);
        }

        for (int i=0; i<buttonId.length; i++) {
            buttons[i] = findViewById(buttonId[i]);
            nums[i] = buttons[i].getText().toString();
        }
    }

    private void setListener() {
        btnSla.setOnClickListener(this);
        btnDol.setOnClickListener(this);

        for (int i=0; i<btnCalcul.length; i++) {
            btnCalcul[i].setOnClickListener(this);
        }

        for (int i=0; i<buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        int numerator;
        int denominator;

        for (int i=0; i<buttons.length; i++) {
            if (v == buttons[i]) {
                if (editNum1.isFocused() == true) {
                    editNum1.append(nums[i]);
                    String str1 = editNum1.getText().toString();
                    Fraction frc1 = new Fraction();
                    num1 = frc1.makeFraction(str1);
                } else if (editNum2.isFocused() == true) {
                    editNum2.append(nums[i]);
                    String str2 = editNum2.getText().toString();
                    Fraction frc2 = new Fraction();
                    num2 = frc2.makeFraction(str2);
                }
            }
        }

        if (v == btnSla) {
            if (editNum1.isFocused() == true) {
                editNum1.append("/");
            } else if (editNum2.isFocused() == true) {
                editNum2.append("/");
            }
        }

        if (v == btnDol) {
            if (editNum1.isFocused() == true) {
                editNum1.setText(null);
            } else if (editNum2.isFocused() == true) {
                editNum2.setText(null);
            }
        }

        for (int i=0; i<btnCalcul.length; i++) {
            if (btnCalcul[i].getText().equals("더하기") && btnCalcul[i] == v) {
                numResult = num1 + num2;
                presentResult(numResult);
            } else if (btnCalcul[i].getText().equals("빼기") && btnCalcul[i] == v) {
                numResult = num1 - num2;
                presentResult(numResult);
            } else if (btnCalcul[i].getText().equals("곱하기") && btnCalcul[i] == v) {
                numResult = num1 * num2;
                presentResult(numResult);
            } else if (btnCalcul[i].getText().equals("나누기") && btnCalcul[i] == v) {
                numResult = num1 / num2;
                presentResult(numResult);
            }
        }
    }//onClick

    void presentResult(double numResult) {
        if (numResult % 1 != 0) {
            Fraction frc = new Fraction();
            String strFraction = frc.presentFraction(numResult);
            txtResult.setText(strFraction);
        } else {
            txtResult.setText("계산결과 : " + String.valueOf(numResult));
        }
    }

}//class