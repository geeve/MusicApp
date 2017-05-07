package com.example.android.musicapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/7 0007.
 */

public class AlbumDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);


        Bundle extras = getIntent().getExtras();

        if(extras == null){
            return;
        }

        String album = extras.getString("album");
        String albumSonger = extras.getString("albumSonger");

        int albumImage = extras.getInt("albumImage");

        ImageView ivAlbum = (ImageView) findViewById(R.id.iv_album_image);
        TextView tvAlbum = (TextView) findViewById(R.id.tv_album_title);
        TextView tvAlbumSonger = (TextView) findViewById(R.id.tv_album_songer);

        ivAlbum.setImageResource(albumImage);

        tvAlbum.setText(album);
        tvAlbumSonger.setText(albumSonger);

    }
}
