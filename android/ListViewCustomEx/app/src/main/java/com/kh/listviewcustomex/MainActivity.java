package com.kh.listviewcustomex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] drawables = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov06, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10
    };

    ArrayList<MovieDto> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        for (int i=0; i<drawables.length; i++) {
            MovieDto dto = new MovieDto(drawables[i],
                    "제목"+(i+1), "부제목"+(i+1));
            list.add(dto);
        }

        /*for (MovieDto dto : list) {
            Log.d("mytag", dto.toString());
        }*/

        MyAdapter adapter = new MyAdapter(this, R.layout.list_cell, list);
        listView.setAdapter(adapter);
    }

}//MainActivity