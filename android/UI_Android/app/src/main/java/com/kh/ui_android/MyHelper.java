package com.kh.ui_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //TBL_STUDENT 테이블 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table TBL_STUDENT (" +
                "     SNO varchar(8) primary key," +
                "     SNAME varchar(10) not null," +
                "     SYEAR int(1) not null," +
                "     GENDER varchar(3) not null," +
                "     MAJOR varchar(10) not null," +
                "     SCORE int(3) not null);";
        db.execSQL(sql);
        //db.close(); //닫아서 에러 생김
    }//onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}//MyHelper
