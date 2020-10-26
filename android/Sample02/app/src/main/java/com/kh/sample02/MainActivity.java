package com.kh.sample02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtInput;
    EditText editText;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
        editText = findViewById(R.id.editInput);
        myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = editText.getText().toString();
        txtInput.setText(name);
    }

}//class