package com.kh.intentextraex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAge;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

                //인텐트에 데이터 넣기
                intent.putExtra("name", name); //key-value pair
                intent.putExtra("age", age);

                startActivity(intent);
            }
        });
    }
}