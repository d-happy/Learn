package com.kh.intentvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView txtWin;
    ImageView imgWin;
    Button btnPrev;

    ListView listView;

    ArrayList<PicDto> list = new ArrayList<>();

    String[] imagesName;
    int[] imagesVote;
    int[] src;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imagesName = getIntent().getStringArrayExtra("imagesName");
        imagesVote = getIntent().getIntArrayExtra("imagesVote");
        src = getIntent().getIntArrayExtra("src");

        findView();
        setUI();

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }//onCreate

    private void setUI() {
        txtWin.setText(imagesName[0]);
        imgWin.setImageResource(src[0]);

        MyAdapter adapter = new MyAdapter(this, R.layout.list_cell, list);
        listView.setAdapter(adapter);
    }//setUI

    private void findView() {
        txtWin = findViewById(R.id.txtWin);
        imgWin = findViewById(R.id.imgWin);
        btnPrev = findViewById(R.id.btnPrev);

        listView = findViewById(R.id.listView);

        for (int i=0; i<imagesName.length; i++) {
            PicDto dto = new PicDto(src[i], imagesName[i], imagesVote[i]);
            list.add(dto);
            Log.d("mytag", dto.toString());
        }
    }//findView

}//ResultActivity