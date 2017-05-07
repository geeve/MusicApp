package com.example.android.musicapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;

import static com.example.android.musicapp.R.drawable.playing;

public class MainActivity extends AppCompatActivity {

    private String playMusicName = null;
    private String playSonger;
    private boolean playing = false;
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TabHost th = (TabHost) findViewById(R.id.tb_tabhost);
        th.setup();
        LayoutInflater i = LayoutInflater.from(this);
        i.inflate(R.layout.activiy_recommand,th.getTabContentView());
        i.inflate(R.layout.activity_album,th.getTabContentView());
        //i.inflate(R.layout.activity_songlist,th.getTabContentView());
        i.inflate(R.layout.activity_musician,th.getTabContentView());

        th.addTab(th.newTabSpec("recommand").setIndicator(getString(R.string.recommand)).setContent(R.id.recommand));
        th.addTab(th.newTabSpec("album").setIndicator(getString(R.string.album)).setContent(R.id.album));
        //th.addTab(th.newTabSpec("songlist").setIndicator(getString(R.string.songlist)).setContent(R.id.songlist));
        th.addTab(th.newTabSpec("musician").setIndicator(getString(R.string.musician)).setContent(R.id.musician));

        LinearLayout recommandSong1 = (LinearLayout) findViewById(R.id.recommand_song1);
        recommandSong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PlayingActivity.class);
                TextView songName = (TextView) findViewById(R.id.tv_song_name1);
                TextView songer = (TextView) findViewById(R.id.tv_songer1);

                playMusicName = songName.getText().toString();
                playSonger = songer.getText().toString();

                i.putExtra("songName",playMusicName);
                i.putExtra("songer",playSonger);


                startActivityForResult(i,REQUEST_CODE);
            }
        });

        LinearLayout recommandSong2 = (LinearLayout) findViewById(R.id.recommand_song2);
        recommandSong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PlayingActivity.class);
                TextView songName = (TextView) findViewById(R.id.tv_song_name2);
                TextView songer = (TextView) findViewById(R.id.tv_songer2);

                playMusicName = songName.getText().toString();
                playSonger = songer.getText().toString();

                i.putExtra("songName",playMusicName);
                i.putExtra("songer",playSonger);


                startActivityForResult(i,REQUEST_CODE);
            }
        });

        LinearLayout recommandSong3 = (LinearLayout) findViewById(R.id.recommand_song3);
        recommandSong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PlayingActivity.class);
                TextView songName = (TextView) findViewById(R.id.tv_song_name3);
                TextView songer = (TextView) findViewById(R.id.tv_songer3);

                playMusicName = songName.getText().toString();
                playSonger = songer.getText().toString();

                i.putExtra("songName",playMusicName);
                i.putExtra("songer",playSonger);



                startActivityForResult(i,REQUEST_CODE);
            }
        });

        LinearLayout recommandSong4 = (LinearLayout) findViewById(R.id.recommand_song4);
        recommandSong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PlayingActivity.class);
                TextView songName = (TextView) findViewById(R.id.tv_song_name4);
                TextView songer = (TextView) findViewById(R.id.tv_songer4);

                playMusicName = songName.getText().toString();
                playSonger = songer.getText().toString();

                i.putExtra("songName",playMusicName);
                i.putExtra("songer",playSonger);



                startActivityForResult(i,REQUEST_CODE);
            }
        });

        LinearLayout recommandSong5 = (LinearLayout) findViewById(R.id.recommand_song5);
        recommandSong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PlayingActivity.class);
                TextView songName = (TextView) findViewById(R.id.tv_song_name5);
                TextView songer = (TextView) findViewById(R.id.tv_songer5);

                playMusicName = songName.getText().toString();
                playSonger = songer.getText().toString();

                i.putExtra("songName",playMusicName);
                i.putExtra("songer",playSonger);



                startActivityForResult(i,REQUEST_CODE);
            }
        });

        LinearLayout recommandSong6 = (LinearLayout) findViewById(R.id.recommand_song6);
        recommandSong6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PlayingActivity.class);
                TextView songName = (TextView) findViewById(R.id.tv_song_name6);
                TextView songer = (TextView) findViewById(R.id.tv_songer6);

                playMusicName = songName.getText().toString();
                playSonger = songer.getText().toString();

                i.putExtra("songName",playMusicName);
                i.putExtra("songer",playSonger);



                startActivityForResult(i,REQUEST_CODE);
            }
        });

        LinearLayout recommandSong7 = (LinearLayout) findViewById(R.id.recommand_song7);
        recommandSong7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PlayingActivity.class);
                TextView songName = (TextView) findViewById(R.id.tv_song_name7);
                TextView songer = (TextView) findViewById(R.id.tv_songer7);

                playMusicName = songName.getText().toString();
                playSonger = songer.getText().toString();

                i.putExtra("songName",playMusicName);
                i.putExtra("songer",playSonger);


                startActivityForResult(i,REQUEST_CODE);
            }
        });

        TextView tvDetail = (TextView) findViewById(R.id.tv_detail);
        tvDetail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new  Intent(MainActivity.this,PlayingActivity.class);

                i.putExtra("songName",playMusicName);
                i.putExtra("songer",playSonger);

                startActivityForResult(i,REQUEST_CODE);
            }
        });



    }

    public void playMusic(View view){
        ImageView play = (ImageView) findViewById(R.id.iv_play_main);
        if(playing){
            play.setImageResource(R.drawable.start);
            playing = false;
        }else{
            play.setImageResource(R.drawable.pause);
            playing = true;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if(data.hasExtra("showMusicName")){
                String showMusicName = data.getExtras().getString("showMusicName");

                if(showMusicName != null && showMusicName.length()>0){
                    TextView tvRecord = (TextView) findViewById(R.id.tv_play_music);
                    tvRecord.setText(playMusicName);
                }
            }
        }
    }

    public void albumDetail1(View view){
        Intent i = new Intent(this,AlbumDetailActivity.class);

        i.putExtra("albumImage",R.drawable.album1);
        TextView album = (TextView) findViewById(R.id.tv_album1);
        TextView albumSonger = (TextView) findViewById(R.id.tv_album1_songer);

        i.putExtra("album",album.getText().toString());
        i.putExtra("albumSonger",albumSonger.getText().toString());

        startActivity(i);
    }

    public void albumDetail2(View view){
        Intent i = new Intent(this,AlbumDetailActivity.class);

        i.putExtra("albumImage",R.drawable.album2);
        TextView album = (TextView) findViewById(R.id.tv_album2);
        TextView albumSonger = (TextView) findViewById(R.id.tv_album1_songer2);

        i.putExtra("album",album.getText().toString());
        i.putExtra("albumSonger",albumSonger.getText().toString());

        startActivity(i);
    }
    public void albumDetail3(View view){
        Intent i = new Intent(this,AlbumDetailActivity.class);

        i.putExtra("albumImage",R.drawable.album3);
        TextView album = (TextView) findViewById(R.id.tv_album3);
        TextView albumSonger = (TextView) findViewById(R.id.tv_album1_songer3);

        i.putExtra("album",album.getText().toString());
        i.putExtra("albumSonger",albumSonger.getText().toString());

        startActivity(i);
    }
    public void albumDetail4(View view){
        Intent i = new Intent(this,AlbumDetailActivity.class);

        i.putExtra("albumImage",R.drawable.album4);
        TextView album = (TextView) findViewById(R.id.tv_album4);
        TextView albumSonger = (TextView) findViewById(R.id.tv_album1_songer4);

        i.putExtra("album",album.getText().toString());
        i.putExtra("albumSonger",albumSonger.getText().toString());

        startActivity(i);
    }

}
