package com.kh.sdcardimageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    ImageButton btnLeft, btnRight;
    ArrayList<File> list = new ArrayList<>();
    int nowIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        getFileList();
        setUI();
        setImage(nowIndex);
    }

    private void setImage(int index) {
        File f = list.get(index);
        String path = f.getAbsolutePath();
        //setImageResource(R.id.1) -> X (res/drawble 의 이미지)
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        imageView.setImageBitmap(bitmap);
    }

    private void setUI() {
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    private void getFileList() {
        String path = "/sdcard";
        File f = new File(path);
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                int dotIndex = fileName.lastIndexOf(".");
                String extName = fileName.substring(dotIndex + 1);
                Log.d("mytag", extName);
                if (extName.equals("png") || extName.equals("jpg") || extName.equals("gif")) {
                    list.add(file);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnLeft) {
            nowIndex--;
            if (nowIndex < 0) {
                nowIndex = list.size()-1;
            }
        } else if (v == btnRight) {
            nowIndex++;
            if (nowIndex >= list.size()) {
                nowIndex = 0;
            }
        }
        setImage(nowIndex);
    }

}//class