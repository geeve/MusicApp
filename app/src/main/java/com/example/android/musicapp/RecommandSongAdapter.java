package com.example.android.musicapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

public class RecommandSongAdapter extends ArrayAdapter<RecommandSong> {

    public RecommandSongAdapter(Activity context, ArrayList<RecommandSong> recommandSongs){
        super(context,0,recommandSongs);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.recommand_list_item,parent,false);
        }

        RecommandSong currentSong = getItem(position);

        TextView tvSongName = (TextView) listItemView.findViewById(R.id.tv_song_name1);
        tvSongName.setText(currentSong.getmRecommandSongName());

        TextView tvSonger = (TextView) listItemView.findViewById(R.id.tv_songer1);
        tvSonger.setText(currentSong.getmRecommandSonger());


        return listItemView;
    }
}
