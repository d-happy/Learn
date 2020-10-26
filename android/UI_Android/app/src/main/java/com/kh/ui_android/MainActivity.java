package com.kh.ui_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInsert, btnUpdate, btnDelete, btnSearch;
    Spinner spinner;
    EditText edtSearch;
    ListView listView;

    String[] spinnerList = {"선택", "이름", "전공"};
    int spinnerIndex = 0;
    final int ALL = 10;
    final int STUDENT_NAME = 20;
    final int STUDENT_MAJOR = 30;
    String search = null;

    List<StudentVo> data = new ArrayList<StudentVo>();

    MyHelper helper = new MyHelper(MainActivity.this,
            "student.db", null, 1);
    StudentDao dao = StudentDao.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao.setMyHelper(helper); //MyHelper 를 StudentDao 에 보내는 메소드
        findView();
        setListener();
        setSpinner();
    }//onCreate

    //검색할 타입 고르는 콤보박스 설정
    private void setSpinner() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                R.layout.support_simple_spinner_dropdown_item, spinnerList);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spinnerIndex = ALL;
                    edtSearch.setText(null);
                    edtSearch.setEnabled(false);
                } else if (position == 1) {
                    spinnerIndex = STUDENT_NAME;
                    edtSearch.setEnabled(true);
                } else if (position == 2) {
                    spinnerIndex = STUDENT_MAJOR;
                    edtSearch.setEnabled(true);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }//setSpinner

    //버튼 클릭할 때 반응하게 설정
    private void setListener() {
        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
    }//setListener

    //레이아웃에서 id값 찾아와서 MainActivity 에서 사용할 수 있게 설정
    private void findView() {
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnSearch = findViewById(R.id.btnSearch);
        spinner = findViewById(R.id.spinner);
        edtSearch = findViewById(R.id.edtSearch);
        listView = findViewById(R.id.listView);
    }//findView

    //버튼마다 서로 다른 반응하도록 설정
    @Override
    public void onClick(View v) {
        if (v == btnInsert) {
            dataInsert();
        }  else if (v == btnUpdate) {
            dataUpdate();
        } else if (v == btnDelete) {
            dataDelete();
        } else if (v == btnSearch) {
            setListView();
        }
    }//onClick

    //입력 누르면 입력창 뜨고, TBL_STUDENT 에 데이터 입력
    private void dataInsert() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("학생정보 입력");
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_insert, null);
        dialog.setView(dialogView);
        //입력창 만들고, 입력라는 창 findViewById
        final EditText edtSnoIn = dialogView.findViewById(R.id.edtSnoIn);
        final EditText edtSnameIn = dialogView.findViewById(R.id.edtSnameIn);
        final EditText edtSyearIn = dialogView.findViewById(R.id.edtSyearIn);
        final RadioButton rdoFemaleIn = dialogView.findViewById(R.id.rdoFemaleIn);
        final RadioButton rdoMaleIn = dialogView.findViewById(R.id.rdoMaleIn);
        final EditText edtMajorIn = dialogView.findViewById(R.id.edtMajorIn);
        final EditText edtScoreIn = dialogView.findViewById(R.id.edtScoreIn);

        //입력창에서 입력된 값들 모아서 StudentVo 객체 생성 후 StudentDao 에 넘겨서 DB에 입력
        dialog.setPositiveButton("입력", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String sno = edtSnoIn.getText().toString();
                    String sname = edtSnameIn.getText().toString();
                    int syear = Integer.parseInt(edtSyearIn.getText().toString());
                    String gender = null;
                    if (rdoFemaleIn.isChecked()) {
                        gender = "여자";
                    } else if (rdoMaleIn.isChecked()) {
                        gender = "남자";
                    }
                    String major = edtMajorIn.getText().toString();
                    int score = Integer.parseInt(edtScoreIn.getText().toString());

                    //2001~2999학번, 1~4학년, 0~100점, 이름과 전공은 공백 아님
                    //조건 걸고 조건 하에 학생 정보 입력 가능
                    int snoNum = Integer.parseInt(sno);
                    String warning = null;

                    if (snoNum < 2001 || snoNum > 2999) {
                        warning = "학번은 2001학번부터 2999학번까지 입력할 수 있습니다.";
                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    } else if (syear < 1 || syear > 4) {
                        warning = "학년은 1학년부터 4학년까지 입력할 수 있습니다.";
                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    } else if (score < 0 || score > 100) {
                        warning = "점수는 0점부터 100점까지 입력할 수 있습니다.";
                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    } else if (sname == null || sname.equals("")) {
                        warning = "이름에 공백은 입력할 수 없습니다.";
                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    } else if (major == null || major.equals("")) {
                        warning = "전공은 공백은 입력할 수 없습니다.";
                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    }else if ((snoNum >=2001 && snoNum <=2999)
                            &&(syear >=1 && syear <=4)&&(score >= 0 && score <= 100)
                            &&(sname != null && !sname.equals(""))&&(major != null && !major.equals(""))) {
                        StudentVo vo = new StudentVo(sno, sname, syear, gender, major, score);
                        String str = dao.insert(vo);
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    }
                    /*StudentVo vo = new StudentVo(sno, sname, syear, gender, major, score);
                    String str = dao.insert(vo);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();*/
                } catch (Exception e) {
                    e.printStackTrace();
                    String warning = "입력창에 모든 내용을 빠짐 없이 입력해주세요";
                    Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                }

                //2001~2999학번, 1~4학년, 0~100점 조건 걸고 조건 하에 학생 정보 입력 가능
                /*int snoNum = Integer.parseInt(sno);
                String warning = null;
                if (snoNum < 2001 || snoNum > 2999) {
                    warning = "학번은 2001학번부터 2999학번까지 입력할 수 있습니다.";
                    Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    edtSnoIn.setText(null);
                } else if (syear < 1 || syear > 4) {
                    warning = "학년은 1학년부터 4학년까지 입력할 수 있습니다.";
                    Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    edtSyearIn.setText(null);
                } else if (score < 0 || score > 100) {
                    warning = "점수는 0점부터 100점까지 입력할 수 있습니다.";
                    Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    edtScoreIn.setText(null);
                } else if ((snoNum >=2001 && snoNum <=2999)
                        &&(syear >=1 && syear <=4)&&(score >= 0 && score <= 100)) {
                    StudentVo vo = new StudentVo(sno, sname, syear, gender, major, score);
                    String str = dao.insert(vo);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                }*/
            }
        });
        dialog.setNegativeButton("닫기", null);
        dialog.show();
    }//dataInsert

    //수정 누르면 수정창에 학번 입력해서, 해당 데이터 불러온 뒤에 수정 후 TBL_STUDENT 에 저장
    private void dataUpdate() {
        final AlertDialog.Builder dialogSer = new AlertDialog.Builder(MainActivity.this);
        dialogSer.setTitle("수정할 학생정보 검색");
        final LayoutInflater inflater = getLayoutInflater();
        final View dialogViewSer = inflater.inflate(R.layout.dialog_search_update, null);
        dialogSer.setView(dialogViewSer);

        final EditText edtSnoUpSer = dialogViewSer.findViewById(R.id.edtSnoUpSer);

        //수정창에서 학번 검색 후, 해당 학생 정보 보여주는 창 띄움
                /*AlertDialog.Builder dialogUp =
                        new AlertDialog.Builder(MainActivity.this);
                dialogUp.setTitle("학생정보 수정");
                View dialogViewUp = inflater.inflate(R.layout.dialog_update, null);
                dialogUp.setView(dialogViewUp);

                final EditText edtSnoUp = dialogViewUp.findViewById(R.id.edtSnoUp);
                final EditText edtSnameUP = dialogViewUp.findViewById(R.id.edtSnameUP);
                final EditText edtSyearUp = dialogViewUp.findViewById(R.id.edtSyearUp);
                final RadioButton rdoFemaleUp = dialogViewUp.findViewById(R.id.rdoFemaleUp);
                final RadioButton rdoMaleUp = dialogViewUp.findViewById(R.id.rdoMaleUp);
                final EditText edtMajorUp = dialogViewUp.findViewById(R.id.edtMajorUp);
                final EditText edtScoreUp = dialogViewUp.findViewById(R.id.edtScoreUp);

                //해당 학생 정도 수정창에 다 보여주고
                edtSnoUp.setText(voSearch.getSno());
                edtSnameUP.setText(voSearch.getSname());
                edtSyearUp.setText(String.valueOf(voSearch.getSyear()));
                Log.d("mytag", voSearch.toString());
                if (voSearch.getGender().equals("여자")) {
                    Log.d("mytag", voSearch.getGender());
                    rdoFemaleUp.setChecked(true);
                } else if (voSearch.getGender().equals("남자")) {
                    Log.d("mytag", voSearch.getGender());
                    rdoMaleUp.setChecked(true);
                }
                edtMajorUp.setText(voSearch.getMajor());
                edtScoreUp.setText(String.valueOf(voSearch.getScore()));

                //수정된 내용으로 StudentVo 객체 하나 만들어서 StudentDao 에 넘겨서
                //해당 학생 정보 업데이트해서 DB 에 저장
                dialogUp.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            String sno = edtSnoUp.getText().toString();
                            String sname = edtSnameUP.getText().toString();
                            int syear = Integer.parseInt(edtSyearUp.getText().toString());
                            String gender = null;
                            if (rdoFemaleUp.isChecked()) {
                                gender = "여자";
                            } else if (rdoMaleUp.isChecked()) {
                                gender = "남자";
                            }
                            String major = edtMajorUp.getText().toString();
                            int score = Integer.parseInt(edtScoreUp.getText().toString());

                            //2001~2999학번, 1~4학년, 0~100점, 이름과 전공은 공백 아님
                            //조건 걸고 조건 하에 학생 정보 입력 가능
                            int snoNum = Integer.parseInt(sno);
                            String warning = null;

                            if (snoNum < 2001 || snoNum > 2999) {
                                warning = "학번은 2001학번부터 2999학번까지 입력할 수 있습니다.";
                                Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                            } else if (syear < 1 || syear > 4) {
                                warning = "학년은 1학년부터 4학년까지 입력할 수 있습니다.";
                                Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                            } else if (score < 0 || score > 100) {
                                warning = "점수는 0점부터 100점까지 입력할 수 있습니다.";
                                Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                            } else if (sname == null || sname.equals("")) {
                                warning = "이름에 공백은 입력할 수 없습니다.";
                                Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                            } else if (major == null || major.equals("")) {
                                warning = "전공은 공백은 입력할 수 없습니다.";
                                Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                            }else if ((snoNum >=2001 && snoNum <=2999)
                                    &&(syear >=1 && syear <=4)&&(score >= 0 && score <= 100)
                                    &&(sname != null && !sname.equals(""))&&(major != null && !major.equals(""))) {
                                StudentVo voUpdate = new StudentVo(sno, sname, syear, gender, major, score);
                                String str = dao.update(voUpdate);
                                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            String warning = "수정창에 모든 내용을 빠짐 없이 입력해주세요";
                            Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                        }
                    }
                });
                dialogUp.setNegativeButton("닫기", null);
                dialogUp.show();
            }
        });*/
        dialogSer.setPositiveButton("검색", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String snoSearch = edtSnoUpSer.getText().toString();
                StudentVo voSearch = new StudentVo();

                try {
                    if (snoSearch == null || snoSearch.equals("")) {
                        String warning = "수정할 학번을 입력해 주세요.";
                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                        //dialogSer.
                    } else if (snoSearch != null && !snoSearch.equals("")) {
                        voSearch = dao.updateSearch(snoSearch);

                        AlertDialog.Builder dialogUp =
                                new AlertDialog.Builder(MainActivity.this);
                        dialogUp.setTitle("학생정보 수정");
                        View dialogViewUp = inflater.inflate(R.layout.dialog_update, null);
                        dialogUp.setView(dialogViewUp);

                        final EditText edtSnoUp = dialogViewUp.findViewById(R.id.edtSnoUp);
                        final EditText edtSnameUP = dialogViewUp.findViewById(R.id.edtSnameUP);
                        final EditText edtSyearUp = dialogViewUp.findViewById(R.id.edtSyearUp);
                        final RadioButton rdoFemaleUp = dialogViewUp.findViewById(R.id.rdoFemaleUp);
                        final RadioButton rdoMaleUp = dialogViewUp.findViewById(R.id.rdoMaleUp);
                        final EditText edtMajorUp = dialogViewUp.findViewById(R.id.edtMajorUp);
                        final EditText edtScoreUp = dialogViewUp.findViewById(R.id.edtScoreUp);

                        //해당 학생 정도 수정창에 다 보여주고
                        edtSnoUp.setText(voSearch.getSno());
                        edtSnameUP.setText(voSearch.getSname());
                        edtSyearUp.setText(String.valueOf(voSearch.getSyear()));
                        Log.d("mytag", voSearch.toString());
                        if (voSearch.getGender().equals("여자")) {
                            Log.d("mytag", voSearch.getGender());
                            rdoFemaleUp.setChecked(true);
                        } else if (voSearch.getGender().equals("남자")) {
                            Log.d("mytag", voSearch.getGender());
                            rdoMaleUp.setChecked(true);
                        }
                        edtMajorUp.setText(voSearch.getMajor());
                        edtScoreUp.setText(String.valueOf(voSearch.getScore()));

                        //수정된 내용으로 StudentVo 객체 하나 만들어서 StudentDao 에 넘겨서
                        //해당 학생 정보 업데이트해서 DB 에 저장
                        dialogUp.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    String sno = edtSnoUp.getText().toString();
                                    String sname = edtSnameUP.getText().toString();
                                    int syear = Integer.parseInt(edtSyearUp.getText().toString());
                                    String gender = null;
                                    if (rdoFemaleUp.isChecked()) {
                                        gender = "여자";
                                    } else if (rdoMaleUp.isChecked()) {
                                        gender = "남자";
                                    }
                                    String major = edtMajorUp.getText().toString();
                                    int score = Integer.parseInt(edtScoreUp.getText().toString());

                                    //2001~2999학번, 1~4학년, 0~100점, 이름과 전공은 공백 아님
                                    //조건 걸고 조건 하에 학생 정보 입력 가능
                                    int snoNum = Integer.parseInt(sno);
                                    String warning = null;

                                    if (snoNum < 2001 || snoNum > 2999) {
                                        warning = "학번은 2001학번부터 2999학번까지 입력할 수 있습니다.";
                                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                                    } else if (syear < 1 || syear > 4) {
                                        warning = "학년은 1학년부터 4학년까지 입력할 수 있습니다.";
                                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                                    } else if (score < 0 || score > 100) {
                                        warning = "점수는 0점부터 100점까지 입력할 수 있습니다.";
                                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                                    } else if (sname == null || sname.equals("")) {
                                        warning = "이름에 공백은 입력할 수 없습니다.";
                                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                                    } else if (major == null || major.equals("")) {
                                        warning = "전공은 공백은 입력할 수 없습니다.";
                                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                                    } else if ((snoNum >= 2001 && snoNum <= 2999)
                                            && (syear >= 1 && syear <= 4) && (score >= 0 && score <= 100)
                                            && (sname != null && !sname.equals("")) && (major != null && !major.equals(""))) {
                                        StudentVo voUpdate = new StudentVo(sno, sname, syear, gender, major, score);
                                        String str = dao.update(voUpdate);
                                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    String warning = "수정창에 모든 내용을 빠짐 없이 입력해주세요";
                                    Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                        dialogUp.setNegativeButton("닫기", null);
                        dialogUp.show();
                    }
                } catch(Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        dialogSer.setNegativeButton("닫기", null);
        dialogSer.show();
    }//dataUpdate

    //삭제 누르면 삭제창에 학번 입력해서, TBL_STUDENT 에서 해당 데이터 삭제
    private void dataDelete() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("학생정보 삭제");
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_delete, null);
        dialog.setView(dialogView);

        //삭제창에서 입력받은 학번 찾은 뒤에
        final EditText edtSnoDel = dialogView.findViewById(R.id.edtSnoDel);

        //삭제 누르면 학번을 StudentDao 로 보내고, StudentDao 에서 해당되는 학생 정보를 삭제
        dialog.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String sno = edtSnoDel.getText().toString();

                    if (sno == null || sno.equals("")) {
                        String warning = "삭제할 학번을 입력해 주세요.";
                        Toast.makeText(MainActivity.this, warning, Toast.LENGTH_LONG).show();
                    } else if (sno != null && !sno.equals("")){
                        String str = dao.delete(sno);
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.setNegativeButton("닫기", null);
        dialog.show();
    }//dataDelete

    //검색 누르면, ListView 설정하고, TBL_STUDENT 데이터 읽어서 ListView 에서 보여줌
    private void setListView() {
        MyAdapter adapter = new MyAdapter(MainActivity.this,
                R.layout.list_cell, data);
        listView.setAdapter(adapter);

        if (edtSearch != null && !edtSearch.equals("")) {
            search = edtSearch.getText().toString();
        }

        //검색할 타입 spinnerIndex, 검색할 내용 search 보내서 해당되는 List<StudentVo> 받기
        data = dao.search(search, spinnerIndex);
    }//setListView

}//MainActivity