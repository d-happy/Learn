package com.kh.viewflipperex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPrev, btnNext, btnStart, btnStop;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        viewFlipper = findViewById(R.id.viewFlipper);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        viewFlipper.setFlipInterval(1000); //1초, (밀리초)
    }

    @Override
    public void onClick(View v) {
        if (v == btnPrev) {
            viewFlipper.showPrevious();
        } else if (v == btnNext) {
            viewFlipper.showNext();
        } else if (v == btnStart) {
            viewFlipper.startFlipping();
        } else if (v == btnStop) {
            viewFlipper.stopFlipping();
        }
    }//onclick

}//class