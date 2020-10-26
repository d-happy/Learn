package com.kh.dialogpet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup;
    //RadioButton rdoPuppy, rdoCat, rdoBird; //굳이 필요하진 않음
    Button btnImage;

    ImageView imgPet;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rGroup = findViewById(R.id.rGroup);
       /* rdoPuppy = findViewById(R.id.rdoPuppy);
        rdoCat = findViewById(R.id.rdoCat);
        rdoBird = findViewById(R.id.rdoBird);*/
        btnImage = findViewById(R.id.btnImage);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog =
                        new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                //dialog.setTitle(str);

                LayoutInflater inflater = getLayoutInflater();
                View dialogPet = inflater.inflate(R.layout.view_pet, null);
                dialog.setView(dialogPet);
                //기본 dialog View 말고 view_pet 으로 한 커스텀 dialog 하려고
                //LayoutInflater 전개자로 View dialogPet 생성
                imgPet = dialogPet.findViewById(R.id.imgPet); //view_pet 에 있는 imgPet

                /*if (rdoPuppy.isChecked() == true) {
                    str = "Puppy";
                    imgPet.setImageResource(R.drawable.puppy);
                }*/ //작동은 함

                int id = rGroup.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.rdoPuppy :
                        str = "Puppy";
                        imgPet.setImageResource(R.drawable.puppy);
                        break;
                    case R.id.rdoCat :
                        str = "Cat";
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdoBird :
                        str = "Bird";
                        imgPet.setImageResource(R.drawable.bird);
                        break;
                }
                //id 따와서 더 정확하고 읽기도 편함

                dialog.setTitle(str); //str 정해진 뒤에!!

                dialog.setNegativeButton("Close", null);
                dialog.show();
            }
        });//setOnClickListener
    }

}//class