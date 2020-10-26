package com.kh.intentvote;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<PicDto> data;

    public MyAdapter(Context context, int layout, ArrayList<PicDto> data) {
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

    // ListView 의 뿌려질 한줄의 Row 를 설정 합니다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) { //없으면 뉴?
            convertView = View.inflate(context, layout, null);
        }

        TextView txtTitle =convertView.findViewById(R.id.txtTitle);
        RatingBar rbStar = convertView.findViewById(R.id.rbStar);

        PicDto dto = data.get(position);
        txtTitle.setText(dto.getImagesName());
        rbStar.setRating(dto.getImagesVote());

        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.GREEN);
        }
        else {
            convertView.setBackgroundColor(Color.YELLOW);
        }

        return convertView;
    }

}//MyAdapter
