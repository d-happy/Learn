package com.kh.dialogcustomex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtName, txtEmail;
    Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //여기서 찾으면 activity_main 에서 찾는 거임
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        btnDialog = findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("사용자 정보 입력");

                //커스텀 뷰
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.view_dialog, null);
                dialog.setView(dialogView);

                //주의사항 : 전개한 뷰에서 findViewById(); 해야 함

                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dialogView.findViewById();
                        EditText edtName = dialogView.findViewById(R.id.edtName);
                        EditText edtEmail = dialogView.findViewById(R.id.edtEmail);
                        String name = edtName.getText().toString();
                        String email = edtEmail.getText().toString();
                        txtName.setText(name);
                        txtEmail.setText(email);
                    }
                });
                dialog.setNegativeButton("취소", null);

                dialog.show();
            }
        });//setOnClickListener
    }
}//class