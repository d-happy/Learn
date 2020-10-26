package com.kh.intentvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtWin;
    ImageView imgWin;
    Button btnPrev;
    TextView[] txt = new TextView[9];
    int[] imgesTxt = {R.id.txt1, R.id.txt2, R.id.txt3, R.id.txt4,
            R.id.txt5, R.id.txt6, R.id.txt7, R.id.txt8, R.id.txt9};
    RatingBar[] star = new RatingBar[9];
    int[] imgesStar = {R.id.star1, R.id.star2, R.id.star3, R.id.star4,
            R.id.star5, R.id.star6, R.id.star7, R.id.star8, R.id.star9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findView();
        setUI();
    }//onCreate

    private void setUI() {
        String[] imagesName = getIntent().getStringArrayExtra("imagesName");
        int[] imagesVote = getIntent().getIntArrayExtra("imagesVote");
        int[] src = getIntent().getIntArrayExtra("src");

        txtWin.setText(imagesName[0]);
        imgWin.setImageResource(src[0]);

        for (int i=0; i<star.length; i++) {
            txt[i].setText(imagesName[i]);
            star[i].setRating(imagesVote[i]);
        }
    }//setUI

    private void findView() {
        for (int i=0; i<star.length; i++) {
            txt[i] = findViewById(imgesTxt[i]);
            star[i] = findViewById(imgesStar[i]);
        }

        txtWin = findViewById(R.id.txtWin);
        imgWin = findViewById(R.id.imgWin);
        btnPrev = findViewById(R.id.btnPrev);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }//findView

}//ResultActivity