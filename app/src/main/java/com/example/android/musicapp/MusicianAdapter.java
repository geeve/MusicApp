package com.example.android.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

public class MusicianAdapter extends ArrayAdapter<Musician> {

    /***
     * 构造函数
     * @param context
     * @param musicians
     */
    public MusicianAdapter(Activity context, ArrayList<Musician> musicians){
        super(context,0,musicians);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;

        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.musician_list_item,parent,false);
        }

        //获得当前位置数据
        Musician currentMusician = getItem(position);

        ImageView musicianImg = (ImageView) listView.findViewById(R.id.iv_musician_img);
        musicianImg.setImageResource(currentMusician.getmImageResourseId());

        TextView musicianSongerName = (TextView) listView.findViewById(R.id.tv_musician_songer_name);
        musicianSongerName.setText(currentMusician.getmMusicianSongerName());

        TextView musicianSongerDetail = (TextView) listView.findViewById(R.id.tv_musician_songer_detail);
        musicianSongerDetail.setText(currentMusician.getmMusicianSongDetail());

        return listView;
    }
}
