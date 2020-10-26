package com.kh.sqliteuser;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
                    //version 1 -> onCreate
                    //version 2 -> onUpgrade, 배포 후 업그레이드
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("mytag", "Helper, onCreate()");
        String sql = "create table tbl_user(" +
            "               user_name varchar(15)," +
                "           user_age int(3))";
        db.execSQL(sql); //sql 실행
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}//MyHelper
