package com.kh.implicitmentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTel, btnNaver, btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTel = findViewById(R.id.btnTel);
        btnNaver = findViewById(R.id.btnNaver);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnTel.setOnClickListener(this);
        btnNaver.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //암시적 인텐트(Implicit Intent)
        if (v == btnTel) {
            Uri uri = Uri.parse("tel:0102345678");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (v == btnNaver) {
            Uri uri = Uri.parse("https://m.naver.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (v == btnGoogle) {
            Uri uri = Uri.parse
                    ("https://maps.google.com/maps?q="+ 37.554364 +","+ 126.913598);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

}//MainActivity