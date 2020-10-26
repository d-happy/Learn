package com.kh.mymp3player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //메니페스트 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    //sd카드 사용 가능?

    ListView listView;
    Button btnPlay, btnPause, btnStop;
    TextView textView;
    ProgressBar progressBar;

    List<String> list = new ArrayList<>(); //파일 이름 담기용
    String selectedFileName;

    MediaPlayer player = new MediaPlayer();
    boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        String path = "/sdcard/Music/";
        File f = new File(path);
        File[] files = f.listFiles();
        for (File aFile : files) {
            String fileName = aFile.getName();
            list.add(fileName);
        }

        Log.d("mytag", list.toString());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_single_choice, list);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //하나씩만 선택 가능
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedFileName = list.get(position);
            }
        });

    }//onCreate

    @Override
    public void onClick(View v) {
        if (v == btnPlay) {
            progressBar.setVisibility(View.VISIBLE);
            String filePath = "/sdcard/Music/" + selectedFileName;
            Log.d("mytag", filePath);
            try {
                if (isPaused == false) {
                    player.setDataSource(filePath);
                }
                player.prepare();
                player.start();
                textView.setText(selectedFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (v == btnPause) {
            progressBar.setVisibility(View.INVISIBLE);
            player.pause();
            isPaused = true;
        } else if (v == btnStop) {
            progressBar.setVisibility(View.INVISIBLE);
            player.stop();
            player.reset();
        }
    }//onClick
}//MainActivity