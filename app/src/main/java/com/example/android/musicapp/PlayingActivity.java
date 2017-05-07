package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.musicapp.R.drawable.playing;

public class PlayingActivity extends AppCompatActivity {

    private boolean playing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);



        Bundle extras = getIntent().getExtras();

        if(extras == null){
            return;
        }

        String songName = extras.getString("songName","未知歌曲");
        String songer = extras.getString("songer","未知歌手");

        TextView tvSongName = (TextView) findViewById(R.id.tv_song_name);
        TextView tvSonger = (TextView) findViewById(R.id.tv_songer);

        tvSongName.setText(songName);
        tvSonger.setText(songer);
    }

    public void playMusic(View view){
        ImageView play = (ImageView) findViewById(R.id.iv_play);
        if(playing){
            play.setImageResource(R.drawable.start);
            playing = false;
        }else{
            play.setImageResource(R.drawable.pause);
            playing = true;
        }

    }

    @Override
    public void finish() {

        TextView tvSongName = (TextView) findViewById(R.id.tv_song_name);
        String showMusicName = tvSongName.getText().toString();

        Intent i = new Intent();
        i.putExtra("showMusicName",showMusicName);
        setResult(RESULT_OK,i);
        super.finish();
    }
}
