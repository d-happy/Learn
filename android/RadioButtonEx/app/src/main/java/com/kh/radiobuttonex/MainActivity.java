package com.kh.radiobuttonex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup;
    RadioButton rdoFemale, rdoMale;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rGroup = findViewById(R.id.rGroup);
        rdoFemale = findViewById(R.id.rdoFemale);
        rdoMale = findViewById(R.id.rdoMale);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rGroup.getCheckedRadioButtonId();
                String str = "";
                switch (id) {
                    case R.id.rdoFemale :
                        str = "Female";
                        break;
                    case R.id.rdoMale :
                        str = "Male";
                        break;
                }
                Toast.makeText(MainActivity.this,
                        str + "을(를) 선택함", Toast.LENGTH_LONG).show();
                //MainActivity.this 해야 오류 노노
            }
        });
    }
}//class