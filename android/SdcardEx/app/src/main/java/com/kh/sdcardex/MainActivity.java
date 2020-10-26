package com.kh.sdcardex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRead, btnMake, btnRemove, btnList;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }

    private void setListener() {
        btnRead.setOnClickListener(this);
        btnMake.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }

    private void findViews() {
        btnRead = findViewById(R.id.btnRead);
        btnMake = findViewById(R.id.btnMake);
        btnRemove = findViewById(R.id.btnRemove);
        btnList = findViewById(R.id.btnList);
        editText = findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        if (v == btnRead) {
            //String fileName = Environment.getExternalStorageDirectory().getPath();
            String fileName = "/sdcard/array.html";
            try {
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    //Log.d("mytag", line);
                    editText.append(line +"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (v == btnMake) {
            String dirName = "/sdcard/sub2";
            File f = new File(dirName);
            f.mkdir(); //make directory
            Toast.makeText(this, "폴더 생성 완료",
                    Toast.LENGTH_LONG).show();
            //Synchronize 해야 보임
        } else if (v == btnRemove) {
            String dirName = "/sdcard/sub2";
            File f = new File(dirName);
            f.delete();
            Toast.makeText(this, "폴더 삭제 완료",
                    Toast.LENGTH_LONG).show();
        } else if (v == btnList) {
            String path = "/sdcard";
            File f = new File(path);
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    editText.append("<폴더>");
                } else {
                    editText.append("<파일>");
                }
                String absPath = file.getAbsolutePath();
                Long length = file.length();
                editText.append(absPath +" ");
                editText.append(length +"\n");
            }
        }
    }//onClick

}//class