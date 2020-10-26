package com.kh.simplediary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth() + 1;
                int day = datePicker.getDayOfMonth();

                String fileName = year +"_"+ month +"_"+ day +".txt";

                try {
                    FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                    String str = editText.getText().toString();
                    byte[] bytes = str.getBytes();
                    fos.write(bytes);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });//setOnClickListener

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String fileName = year +"_"+ (monthOfYear + 1) +"_"+ dayOfMonth +".txt";
                Log.d("tag", fileName);
                //읽기
                try {
                    FileInputStream fis = openFileInput(fileName);
                    int size = fis.available();
                    byte[] bytes = new byte[size];
                    fis.read(bytes);
                    String str = new String(bytes);
                    editText.setText(str);
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}//class