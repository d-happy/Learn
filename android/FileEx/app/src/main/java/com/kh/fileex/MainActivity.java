package com.kh.fileex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnWrite, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnWrite) {
            //OutputStream
            try {
                FileOutputStream fos = openFileOutput("file.txt", MODE_PRIVATE);
                String str = "안녕하세요. Hello.";
                byte[] bytes = str.getBytes();
                fos.write(bytes);
                Toast.makeText(this, "파일 쓰기 완료", Toast.LENGTH_LONG).show();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (v == btnRead) {
            //InputStream
            try {
                FileInputStream fis = openFileInput("file.txt");
                byte[] bytes = new byte[30];
                fis.read(bytes);
                String str = new String(bytes);
                Toast.makeText(this, str, Toast.LENGTH_LONG).show();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//onClick

} //class