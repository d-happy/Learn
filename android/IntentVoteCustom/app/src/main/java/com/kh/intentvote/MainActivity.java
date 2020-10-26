package com.kh.intentvote;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] src = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
    String[] imagesName = {"책소녀", "모자소녀", "부채소녀", "긴머리소녀",
            "조는소녀", "두소녀", "피아노소녀", "피아노두소녀", "의자소녀"};
    int[] imagesVote = new int[src.length];

    List<PicDto> list = new ArrayList<>();

    Button btnNext;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        vote();
    }

    private void findView() {
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);

        gridView = findViewById(R.id.gridView);

        for (int i=0; i<src.length; i++) {
            PicDto dto = new PicDto(src[i], imagesName[i], imagesVote[i]);
            list.add(dto);
            Log.d("mytag", dto.toString());
        }

        MyAdapter2 adapterGrid = new MyAdapter2(this, R.layout.gird_cell, list);
        gridView.setAdapter(adapterGrid);
    }//findView

    private void vote() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                AlertDialog.Builder dialog =
                        new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("득표수");

                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_view, null);

                PicDto dto = list.get(position); //dto 먼저 만들고

                for(int i=0; i<src.length; i++) {
                    if (position == i) {
                        if (imagesVote[i] < 5) {
                            imagesVote[i]++;
                            dto.setImagesVote(imagesVote[i]); //투표수 세터로 넘기고
                        }
                        if (imagesVote[i] == 5) {
                            view.setBackgroundColor(Color.RED);
                            //imagesVote[i]+=0;
                        }
                        Log.d("mytag", imagesName[i] + " : " + imagesVote[i]);
                    }
                }//list[i]

                TextView dialogTitle = dialogView.findViewById(R.id.dialogTitle);
                TextView dialogVote = dialogView.findViewById(R.id.dialogVote);
                //PicDto dto = list.get(position);
                dialogTitle.setText(dto.getImagesName());
                dialogVote.setText(String.valueOf(dto.getImagesVote()));
                Log.d("mytag", dto.toString()); //게터로 가져와서 설정

                dialog.setView(dialogView);

                dialog.setNegativeButton("닫기", null);
                dialog.show();
            }
        });//setOnItemClickListener
    }//vote

    @Override
    public void onClick(View v) {
        if (v == btnNext) {
            rank();

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("src", src); //int[]
            intent.putExtra("imagesName", imagesName); //String[]
            intent.putExtra("imagesVote", imagesVote); //int[]
            startActivity(intent);
        }
    }//onClick

    private void rank() {
        int tempNum = 0;
        String tempStr = "null";

        for (int i=0; i < src.length; i++) {
            for (int j=0; j < i; j++) { //Like 로또 반복 제거
                if (imagesVote[i] > imagesVote[j]) {
                    tempNum = src[j];
                    src[j] = src[i];
                    src[i] = tempNum;

                    tempStr = imagesName[j];
                    imagesName[j] = imagesName[i];
                    imagesName[i] = tempStr;

                    tempNum = imagesVote[j];
                    imagesVote[j] = imagesVote[i];
                    imagesVote[i] = tempNum;
                }
            }
        }//for
    }//rank

}//MainActivity