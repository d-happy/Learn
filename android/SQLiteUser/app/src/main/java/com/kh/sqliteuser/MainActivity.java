package com.kh.sqliteuser;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInit, btnSelect, btnInsert;
    EditText edtName, edtAge;
    TextView txtName, txtAge;
    MyHelper helper = new MyHelper(this, //getApplicationContext() : X
            "user.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
    }

    private void setListener() {
        btnInit.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
    }

    private void findView() {
        btnInit = findViewById(R.id.btnInit);
        btnSelect = findViewById(R.id.btnSelect);
        btnInsert = findViewById(R.id.btnInsert);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
    }

    @Override
    public void onClick(View v) {
        if (v == btnInit) {
            SQLiteDatabase sdb = helper.getWritableDatabase();
            sdb.close();
        } else if (v == btnSelect) {
            String sql = "select * from tbl_user";
            SQLiteDatabase sdb = helper.getWritableDatabase();
            Cursor cursor = sdb.rawQuery(sql, null);
            //rs.next()
            txtName.setText("");
            txtAge.setText("");
            while (cursor.moveToNext()) {
                String user_name = cursor.getString(0);
                int user_age = cursor.getInt(1);
                txtName.append(user_name+"\n");
                txtAge.append(user_age+"\n");
            }
            cursor.close();
            sdb.close();
        } else if (v == btnInsert) {
            String name = edtName.getText().toString();
            int age = Integer.parseInt(edtAge.getText().toString());
            String sql = "insert into tbl_user(user_name, user_age)" +
                    "     values('"+ name +"', "+ age +")";
            SQLiteDatabase sdb = helper.getWritableDatabase();
            sdb.execSQL(sql);
            sdb.close();
        }
    }
}//MainActivity