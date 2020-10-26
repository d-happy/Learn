package com.kh.gridviewex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    List<MovieDto> list = new ArrayList<>(); //List 안에 ArrayList
    int[] drawable = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov09, R.drawable.mov08, R.drawable.mov07,
            R.drawable.mov10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        for (int i=0; i<100; i++) {
            MovieDto dto = new MovieDto(drawable[i % 10], "제목" + (i+1));
            list.add(dto);
        }

        for (MovieDto dto : list) {
            Log.d("mytag", dto.toString());
        }

        MyAdapter adapter = new MyAdapter(this, R.layout.grid_cell, list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog =
                        new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("영화 포스터");

                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_view, null);

                TextView dialogTitle = dialogView.findViewById(R.id.dialogTitle);
                ImageView dialogImage = dialogView.findViewById(R.id.dialogImage);

                MovieDto dto = list.get(position);
                dialogTitle.setText(dto.getTitle());
                dialogImage.setImageResource(dto.getDrawable());

                dialog.setView(dialogView);

                dialog.setNegativeButton("닫기", null);
                dialog.show();
            }
        });
    }

}//MainActivity