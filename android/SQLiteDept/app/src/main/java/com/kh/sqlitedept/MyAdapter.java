package com.kh.sqlitedept;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<DeptVo> data;

    public MyAdapter(Context context, int layout, List<DeptVo> data) {
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

        TextView txtDeptNo = convertView.findViewById(R.id.txtDeptNo);
        TextView txtDname = convertView.findViewById(R.id.txtDname);
        TextView txtLoc = convertView.findViewById(R.id.txtLoc);

        DeptVo vo = data.get(position);
        txtDeptNo.setText(String.valueOf(vo.getDeptNo()));
        txtDname.setText(vo.getDeptName());
        txtLoc.setText(vo.getDeptLocation());

        return convertView;
    }
}//MyAdapter
