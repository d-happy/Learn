package com.kh.ui_android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    final int STUDENT_NAME = 20;
    final int STUDENT_MAJOR = 30;

    private static StudentDao instance;
    private StudentDao() { /*singleton*/ };
    public static StudentDao getInstance() {
        if (instance == null) {
            instance = new StudentDao();
        }
        return instance;
    }

    MyHelper helper = null;

    public void setMyHelper(MyHelper helper) {
        this.helper = helper;
    }

    //TBL_STUDENT 테이블에 데이터 입력
    public String insert(StudentVo vo) {
        SQLiteDatabase sdb = helper.getWritableDatabase();

        String sno = vo.getSno();
        String sname = vo.getSname();
        int syear = vo.getSyear();
        String gender = vo.getGender();
        String major = vo.getMajor();
        int score = vo.getScore();

        String sql = "insert into TBL_STUDENT" +
                "     values ('"+sno+"', '"+sname+"', "+
                                syear+", '"+gender+"', '"+major+"', "+score+")";
        sdb.execSQL(sql);
        sdb.close();
        String str = sname +" 학생의 정보가 입력됐습니다.";
        return str;
    }//insert

    //TBL_STUDENT 에서 해당 학번을 가진 학생의 데이터 보내주기
    public StudentVo updateSearch(String snoSearch) {
        SQLiteDatabase sdb = helper.getReadableDatabase();

        String sql = "select * from TBL_STUDENT where SNO = '"+snoSearch+"'";

        StudentVo vo = new StudentVo();
        Cursor cursor = sdb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String sno = cursor.getString(0);
            String sname = cursor.getString(1);
            int syear = cursor.getInt(2);
            String gender = cursor.getString(3);
            String major = cursor.getString(4);
            int score = cursor.getInt(5);

            vo = new StudentVo(sno, sname, syear, gender, major, score);
        }
        return vo;
    }//

    //TBL_STUDENT 에서 해당 학번을 가진 학생의 수정된 데이터 저장
    public String update(StudentVo voUpdate) {
        Log.d("mytag", voUpdate.toString());

        SQLiteDatabase sdb = helper.getWritableDatabase();

        String sno = voUpdate.getSno();
        String sname = voUpdate.getSname();
        int syear = voUpdate.getSyear();
        String gender = voUpdate.getGender();
        String major = voUpdate.getMajor();
        int score = voUpdate.getScore();

        String sql = "update TBL_STUDENT" +
                "     set SNAME = '"+sname+"'," +
                "         SYEAR = "+syear+", " +
                "         GENDER = '"+gender+"', " +
                "         MAJOR = '"+major+"', " +
                "         SCORE = "+score+"" +
                "     where SNO = '"+sno+"'";
        sdb.execSQL(sql);
        sdb.close();
        String str = sname +" 학생의 정보가 수정됐습니다.";
        return str;
    }//update

    //TBL_STUDENT 에서 해당 학번을 가진 학생의 데이터 삭제
    public String delete(String sno) {
        SQLiteDatabase sdb = helper.getWritableDatabase();

        String sql = "delete from TBL_STUDENT where SNO = '"+sno+"'";
        sdb.execSQL(sql);
        sdb.close();
        String str = sno +" 학번을 가진 학생의 정보가 삭제됐습니다.";
        return str;
    }//delete

    //student.db 안의 TBL_STUDENT 테이블 읽기
    public List<StudentVo> search(String search, int spinnerIndex) {
        SQLiteDatabase sdb = helper.getReadableDatabase();

        String sql = "select * from TBL_STUDENT";
        if (search != null && !search.equals("") && spinnerIndex == STUDENT_NAME) {
            sql += "  where SNAME like '%"+ search +"%'";
        } else if (search != null && !search.equals("") && spinnerIndex == STUDENT_MAJOR) {
            sql += "  where MAJOR like '%"+ search +"%'";
        }
        sql += "      order by SNO asc";

        List<StudentVo> list = new ArrayList<>();
        Cursor cursor = sdb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String sno = cursor.getString(0);
            String sname = cursor.getString(1);
            int syear = cursor.getInt(2);
            String gender = cursor.getString(3);
            String major = cursor.getString(4);
            int score = cursor.getInt(5);

            StudentVo vo = new StudentVo(sno, sname, syear, gender, major, score);
            list.add(vo);
        }
        return list;
    }//search

}//StudentDao
