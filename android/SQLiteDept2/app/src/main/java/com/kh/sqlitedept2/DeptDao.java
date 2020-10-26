package com.kh.sqlitedept2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DeptDao {

    private static DeptDao instance;
    private DeptDao() { /*singleton*/ }
    public static DeptDao getInstance() {
        if (instance == null) {
            instance = new DeptDao();
        }
        return instance;
    }

    //DeptHelper 를 메인에 만들고, 게터세터로 Dao 에 가져와서 사용
    DeptHelper helper = null;

    public void deptHelperSet(DeptHelper helper) {
        this.helper = helper;
    }

    public void insert(DeptVo voInsert) {
        SQLiteDatabase sdb = helper.getWritableDatabase();

        int no = voInsert.getDeptNo();
        String name = voInsert.getDeptName();
        String loc = voInsert.getDeptLocation();

        String sql = "insert into tbl_dept(deptno, dname, loc)" +
                " values("+ no +", '"+ name +"', '"+ loc +"')";
        sdb.execSQL(sql);
        sdb.close();
    }//insert

    public List<DeptVo> read(int indexSearch, String dataSearch) {
        SQLiteDatabase sdb = helper.getReadableDatabase();

        String sql ="select * from tbl_dept";

        if (indexSearch == 10) {
            Log.d("mytag-Dao", "indexSearch : 10");
        } else if (indexSearch == 20) {
            Log.d("mytag-Dao", "indexSearch : 20 |"+ dataSearch);
            sql += "    where dname like '%"+dataSearch+"%' ";
        } else if (indexSearch == 30) {
            Log.d("mytag-Dao", "indexSearch : 30 |"+ dataSearch);
            sql += "    where loc like '%"+dataSearch+"%' ";
            //"□where ~~~"; -> □ : 최소 1칸은 공백이어야, sql 실행 가능
        }
        sql += "    order by deptno asc;";

        Cursor cursor = sdb.rawQuery(sql, null);
        //데이터베이스에 저장되어 있는 테이블의 행을 참조하여 데이터 가져옴

        List<DeptVo> list = new ArrayList<>();
        while (cursor.moveToNext()) { //Cursor 가 다음칸으로 이동하는 동안 무한반복
            int no = cursor.getInt(0);
            String name = cursor.getString(1);
            String loc = cursor.getString(2);

            DeptVo vo = new DeptVo(no, name, loc);
            list.add(vo);
        }

        cursor.close();
        sdb.close();

        return list;
    }//read

    public String upgrade(DeptVo voGet) {
        SQLiteDatabase sdb = helper.getWritableDatabase();

        int no = voGet.getDeptNo();
        String name = voGet.getDeptName();
        String loc = voGet.getDeptLocation();

        String sql = "update tbl_dept set " +
                "   dname = '" + name +"', " +
                "   loc = '" + loc +"'" +
                "   where deptno = "+ no;
        sdb.execSQL(sql);
        sdb.close();

        String str = no+"번의 부서가 수정!!!!";
        return str;
    }//upgrade

    public String delete(DeptVo voGet) {
        SQLiteDatabase sdb = helper.getWritableDatabase();

        int no = voGet.getDeptNo();

        String sql = "delete from tbl_dept where deptno = "+no+"";
        sdb.execSQL(sql);
        sdb.close();

        String str = no+"번의 부서가 삭제!!!!";
        return str;
    }//delete

}//DeptDao
