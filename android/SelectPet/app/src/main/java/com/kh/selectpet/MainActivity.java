package com.kh.selectpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkStart;
    TextView txtChoice;
    RadioGroup rGroup;
    RadioButton rdoDog, rdoCat, rdoBird;
    Button btnCheck, btnRot;
    ImageView imv;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdoDog.isChecked() == true) {
                    imv.setImageResource(R.drawable.puppy);
                    imv.setVisibility(View.VISIBLE);
                    Log.d("mytag", "puppyok");
                } else if (rdoCat.isChecked() == true) {
                    imv.setImageResource(R.drawable.cat);
                    imv.setVisibility(View.VISIBLE);
                    Log.d("mytag", "catok");
                } else if (rdoBird.isChecked() == true) {
                    imv.setImageResource(R.drawable.bird);
                    imv.setVisibility(View.VISIBLE);
                    Log.d("mytag", "birdok");
                }
            }
        }); //setOnClickListener

        btnRot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i +=10;
                imv.setRotation(i);
            }
        });//setOnClickListener
    }

    private void findview() {
        chkStart = findViewById(R.id.chkStart);
        rGroup = findViewById(R.id.rGroup);
        txtChoice = findViewById(R.id.txtChoice);
        rdoDog = findViewById(R.id.rdoDog);
        rdoCat = findViewById(R.id.rdoCat);
        rdoBird = findViewById(R.id.rdoBird);
        btnCheck = findViewById(R.id.btnCheck);
        btnRot = findViewById(R.id.btnRot);
        imv = findViewById(R.id.imv);
    };

    public void show1(View v) {
        txtChoice.setVisibility(View.VISIBLE);
        rGroup.setVisibility(View.VISIBLE);
        Log.d("mytag", "ok");
        btnCheck.setVisibility(View.VISIBLE);
        btnRot.setVisibility(View.VISIBLE);
    };

}//class