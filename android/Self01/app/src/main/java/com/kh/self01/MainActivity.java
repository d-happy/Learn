package com.kh.self01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    TextView txt;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        txt = findViewById(R.id.txt);
        edit = findViewById(R.id.edit);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String txtsome = edit.getText().toString();
        txt.setText(txtsome);
    }
}