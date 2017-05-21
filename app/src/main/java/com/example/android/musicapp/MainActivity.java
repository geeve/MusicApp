package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String playMusicName = null;
    private String playSonger;
    private boolean playing = false;
    private static final int REQUEST_CODE = 10;

    //存放推荐歌曲列表的ArrayList
    private ArrayList<RecommandSong> mRecommandSongs = new ArrayList<RecommandSong>();


    /***
     * 实例化各ArrayList
     */
    private void createObj(){
        mRecommandSongs.add(new RecommandSong("推荐歌曲1","歌手1"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲2","歌手2"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲3","歌手3"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲4","歌手4"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲5","歌手5"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲6","歌手6"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲7","歌手7"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TabHost th = (TabHost) findViewById(R.id.tb_tabhost);
        th.setup();
        LayoutInflater i = LayoutInflater.from(this);
        i.inflate(R.layout.activiy_recommand2,th.getTabContentView());
        i.inflate(R.layout.activity_album,th.getTabContentView());
        //i.inflate(R.layout.activity_songlist,th.getTabContentView());
        i.inflate(R.layout.activity_musician,th.getTabContentView());

        th.addTab(th.newTabSpec("recommand").setIndicator(getString(R.string.recommand)).setContent(R.id.recommand));
        th.addTab(th.newTabSpec("album").setIndicator(getString(R.string.album)).setContent(R.id.album));
        //th.addTab(th.newTabSpec("songlist").setIndicator(getString(R.string.songlist)).setContent(R.id.songlist));
        th.addTab(th.newTabSpec("musician").setIndicator(getString(R.string.musician)).setContent(R.id.musician));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        createObj();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        RecommandSongAdapter recommandSongAdapter = new RecommandSongAdapter(this,mRecommandSongs);

        ListView listView = (ListView)findViewById(R.id.recommand);

        listView.setAdapter(recommandSongAdapter);


//        LinearLayout recommandSong1 = (LinearLayout) findViewById(R.id.recommand_song1);
//        recommandSong1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this,PlayingActivity.class);
//                TextView songName = (TextView) findViewById(R.id.tv_song_name1);
//                TextView songer = (TextView) findViewById(R.id.tv_songer1);
//
//                playMusicName = songName.getText().toString();
//                playSonger = songer.getText().toString();
//
//                i.putExtra("songName",playMusicName);
//                i.putExtra("songer",playSonger);
//
//
//                startActivityForResult(i,REQUEST_CODE);
//            }
//        });


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
