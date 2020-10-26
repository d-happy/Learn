package com.kh.framelayoutex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] btnIds = {
            R.id.btnPuppy, R.id.btnCat, R.id.btnBird
    };
    Button[] buttons =new Button[btnIds.length];
    int[] imvIds = {
            R.id.imvPuppy, R.id.imvCat, R.id.imvBird
    };
    ImageView[] imvs= new ImageView[imvIds.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0; i<btnIds.length; i++) {
            buttons[i] = findViewById(btnIds[i]);
            buttons[i].setOnClickListener(this);
            imvs[i] = findViewById(imvIds[i]);
            imvs[i].setOnClickListener(this);
        }
    }

    private void hideAllImages() {
        for (ImageView iv : imvs) {
            iv.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        hideAllImages();
        for (int i=0; i<buttons.length; i++) {
            if (v == buttons[i]) {
                imvs[i].setVisibility(View.VISIBLE);
                break;
            }
        }
        /*int id = v.getId();
        switch (id) {
            case R.id.btnPuppy :
                break;
            case R.id.btnCat :
                break;
            case R.id.btnBird :
                break;
        }*/
    }

}//class