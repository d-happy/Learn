package com.kh.sqlitedept2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DeptHelper extends SQLiteOpenHelper {

    public DeptHelper(@Nullable Context context, @Nullable String name,
                      @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("mytag-helper", "DeptHelper-onCreate");

        String sql = "create table tbl_dept(" +
                "                   deptno int(2) primary key," +
                "                   dname varchar(10)," +
                "                   loc varchar(10))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlonUpgrade = "drop table tbl_dept";
        db.execSQL(sqlonUpgrade);
        onCreate(db);
    }

}//DeptHelper
