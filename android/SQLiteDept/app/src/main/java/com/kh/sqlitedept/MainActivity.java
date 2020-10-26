package com.kh.sqlitedept;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInsert, btnSelect;
    ListView listView;

    DeptVo vo1 = new DeptVo(10, "hi", "us");
    DeptVo vo2 = new DeptVo(20, "hello", "hk");
    DeptVo vo3 = new DeptVo(30, "bye", "ny");
    List<DeptVo> data = new ArrayList<>();

    DeptHelper helper =
            new DeptHelper(this, "Dept.db", null, 1);

    DeptDao dao = DeptDao.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao.deptHelperSet(helper);

        findView();
        setListener();
    }

    private void setListener() {
        btnInsert.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
    }

    private void findView() {
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        listView = findViewById(R.id.listView);
    }

    @Override
    public void onClick(View v) {
        if (v == btnInsert) {
            dataInsert();
            /*data.add(vo1);
            data.add(vo2);
            data.add(vo3);*/
        } else if (v == btnSelect) {
            setListView();
            dataUpgrade();
        }
    }

    private void dataInsert() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("입력");

        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_view, null);
        //왜 final 인지 모름... 붙어야 setPositiveButton 해서 저장 가능
        dialog.setView(dialogView);

        /*EditText edtDeptNo = dialogView.findViewById(R.id.edtDeptNo);
        EditText edtDname = dialogView.findViewById(R.id.edtDname);
        EditText edtLoc = dialogView.findViewById(R.id.edtLoc);
        deptNo = Integer.parseInt(edtDeptNo.getText().toString());
        deptName = edtDname.getText().toString();
        deptLoc = edtLoc.getText().toString();*/

        dialog.setPositiveButton("입력", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText edtDeptNo = dialogView.findViewById(R.id.edtDeptNo);
                EditText edtDname = dialogView.findViewById(R.id.edtDname);
                EditText edtLoc = dialogView.findViewById(R.id.edtLoc);

                int deptNo = Integer.parseInt(edtDeptNo.getText().toString());
                String deptName = edtDname.getText().toString();
                String deptLoc = edtLoc.getText().toString();

                DeptVo voInsert = new DeptVo(deptNo, deptName, deptLoc);
                dao.insert(voInsert);
                /*dao.insert(vo1);
                dao.insert(vo2);
                dao.insert(vo3);
                data.add(voInsert);
                Log.d("mytag", voInsert.toString());*/
            }
        });

        dialog.setNegativeButton("닫기", null);
        dialog.show();
    }//dataInsert

    private void dataUpgrade() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("");
                LayoutInflater inflater = getLayoutInflater();
                final View dialogViewItem =
                        inflater.inflate(R.layout.dialog_item, null);
                dialog.setView(dialogViewItem);

                /*Log.d("mytag", String.valueOf(position));
                Log.d("mytag-", String.valueOf(data.get(position)));*/

                final DeptVo voGet = data.get(position);

                EditText edtDeptNoSearch = dialogViewItem.findViewById(R.id.edtDeptNoSearch);
                EditText edtDnameSearch = dialogViewItem.findViewById(R.id.edtDnameSearch);
                EditText edtLocSearch = dialogViewItem.findViewById(R.id.edtLocSearch);

                int noSearch = voGet.getDeptNo();
                String nameSearch = voGet.getDeptName();
                String locSearch = voGet.getDeptLocation();

                edtDeptNoSearch.setText(String.valueOf(noSearch));
                edtDnameSearch.setText(nameSearch);
                edtLocSearch.setText(locSearch);

                dialog.setNeutralButton("닫기", null);
                dialog.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //data.remove(position);
                        String str = dao.delete(voGet);
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText edtDeptNoSearch = dialogViewItem.findViewById(R.id.edtDeptNoSearch);
                        EditText edtDnameSearch = dialogViewItem.findViewById(R.id.edtDnameSearch);
                        EditText edtLocSearch = dialogViewItem.findViewById(R.id.edtLocSearch);

                        int noUpgrade = Integer.parseInt(edtDeptNoSearch.getText().toString());
                        String nameUpgrade = edtDnameSearch.getText().toString();
                        String locUpgrade = edtLocSearch.getText().toString();

                        voGet.setDeptNo(noUpgrade);
                        voGet.setDeptName(nameUpgrade);
                        voGet.setDeptLocation(locUpgrade);

                        String str = dao.upgrade(voGet);
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                        //Log.d("mytag", voGet.toString());
                    }
                });//수정
                dialog.show();
            }
        });
    }//dataUpgrade

    private void setListView() {
        /*data.add(vo1);
        data.add(vo2);
        data.add(vo3);
        Log.d("mytag-list", String.valueOf(data));*/

        data = dao.read();

        MyAdapter adapter = new MyAdapter(this, R.layout.list_cell, data);
        listView.setAdapter(adapter);
    }//setListView

}//MainActivity