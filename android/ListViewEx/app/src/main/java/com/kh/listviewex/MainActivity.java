package com.kh.listviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] data = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        //어댑터 : 뷰 + 데이터 연결
        ArrayAdapter<String> adaptor = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, //TextView
                data
        );
        //각각의 데이터에 따라서 뷰가 반복적으로 적용됨 ()

        listView.setAdapter(adaptor); //만든 어댑터를 리스트뷰에 적용

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        data[position] +"을 선택함", Toast.LENGTH_SHORT).show();
                //R.string.your_name 을 text: 부분이 맞음?


            }
        });
    }//onCreate

}//MainActivity