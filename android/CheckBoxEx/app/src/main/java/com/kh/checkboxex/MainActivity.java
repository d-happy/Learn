package com.kh.checkboxex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox chkJAva, chkPython, chkCsharp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        setListener();
    }

    private void setListener() {
        chkJAva.setOnCheckedChangeListener(this);
        chkPython.setOnCheckedChangeListener(this);
        chkCsharp.setOnCheckedChangeListener(this);
    }

    private void findview() {
        chkJAva = findViewById(R.id.chkJAva);
        chkPython = findViewById(R.id.chkPython);
        chkCsharp = findViewById(R.id.chkCsharp);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == true) {
            String str = "";
            if (buttonView == chkJAva) {
                str = "JAVA";
            } else if (buttonView == chkPython) {
                str = "Python";
            } else if (buttonView == chkCsharp) {
                str = "C#";
            }

            Toast.makeText(this,
                    str + "을(를) 선택하셨습니다.", Toast.LENGTH_LONG).show();
        }
    }

}//class