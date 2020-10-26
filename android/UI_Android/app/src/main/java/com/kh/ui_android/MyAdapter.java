package com.kh.ui_android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<StudentVo> data;

    public MyAdapter(Context context, int layout, List<StudentVo> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, layout, null);
        }

        TextView txtSno = convertView.findViewById(R.id.txtSno);
        TextView txtSname = convertView.findViewById(R.id.txtSname);
        TextView txtSyear = convertView.findViewById(R.id.txtSyear);
        TextView txtGender = convertView.findViewById(R.id.txtGender);
        TextView txtMajor = convertView.findViewById(R.id.txtMajor);
        TextView txtScore = convertView.findViewById(R.id.txtScore);

        StudentVo vo = data.get(position);

        txtSno.setText(vo.getSno());
        txtSname.setText(vo.getSname());
        txtSyear.setText(String.valueOf(vo.getSyear())); //int 값 String 으로 넣기
        txtGender.setText(vo.getGender());
        txtMajor.setText(vo.getMajor());
        txtScore.setText(String.valueOf(vo.getScore()));

        return convertView;
    }//getView

}//MyAdapter
