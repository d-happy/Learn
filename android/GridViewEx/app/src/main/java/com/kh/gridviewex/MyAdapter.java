package com.kh.gridviewex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<MovieDto> data;

    public MyAdapter(Context context, int layout, List<MovieDto> data) {
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

        ImageView cellImage = convertView.findViewById(R.id.cellImage);
        TextView cellTitle = convertView.findViewById(R.id.cellTitle);

        MovieDto dto = data.get(position);
        cellImage.setImageResource(dto.getDrawable());
        cellTitle.setText(dto.getTitle());

        return convertView;
    }

}//MyAdapter
