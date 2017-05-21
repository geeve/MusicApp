package com.example.android.musicapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

public class AlbumAdapter extends BaseAdapter {

    private Context mContext;

    private ArrayList<Album> mAlbums = new ArrayList<Album>();

    public AlbumAdapter(Activity context, ArrayList<Album> albums){

        super();
        this.mAlbums = albums;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mAlbums.size();
    }

    @Override
    public Object getItem(int i) {
        return mAlbums.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if(gridView == null){
            gridView = LayoutInflater.from(this.mContext).inflate(R.layout.album_list_item,parent,false);
        }

        Album currentAlbum = mAlbums.get(position);

        ImageView ivAlbumImg = (ImageView) gridView.findViewById(R.id.iv_album1);
        ivAlbumImg.setImageResource(currentAlbum.getmImgResourseId());

        TextView tvAlbumName = (TextView) gridView.findViewById(R.id.tv_album1);
        tvAlbumName.setText(currentAlbum.getmAlbumName());

        TextView tvAlbumSonger = (TextView) gridView.findViewById(R.id.tv_album1_songer);
        tvAlbumSonger.setText(currentAlbum.getmAlbumSonger());

        return gridView;
    }
}
