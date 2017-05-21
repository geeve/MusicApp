package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
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
    //存放歌手信息的ArrayList
    private ArrayList<Musician> mMusicians = new ArrayList<Musician>();
    //存放专辑列表ArrayList
    private ArrayList<Album> mAlbums = new ArrayList<Album>();


    /***
     * 初始化推荐歌曲页面
     */
    private void createRecommandSong(){


        mRecommandSongs.add(new RecommandSong("推荐歌曲1","歌手1"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲2","歌手2"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲3","歌手3"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲4","歌手4"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲5","歌手5"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲6","歌手6"));
        mRecommandSongs.add(new RecommandSong("推荐歌曲7","歌手7"));

        RecommandSongAdapter recommandSongAdapter = new RecommandSongAdapter(this,mRecommandSongs);

        ListView listView = (ListView)findViewById(R.id.recommand);

        listView.setAdapter(recommandSongAdapter);

        /***
         * 绑定每项点击事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,PlayingActivity.class);

                playMusicName = mRecommandSongs.get(i).getmRecommandSongName();
                playSonger = mRecommandSongs.get(i).getmRecommandSonger();

                intent.putExtra("songName",playMusicName);
                intent.putExtra("songer",playSonger);

                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    /***
     * 初始化音乐人页面
     */
    private void createMusician(){
        mMusicians.add(new Musician(getResources().getString(R.string.ldh),getResources().getString(R.string.ldh_detail),R.drawable.ldh));
        mMusicians.add(new Musician(getResources().getString(R.string.zgr),getResources().getString(R.string.zgr_detail),R.drawable.zgr));
        mMusicians.add(new Musician(getResources().getString(R.string.myf),getResources().getString(R.string.myf_detail),R.drawable.myf));
        mMusicians.add(new Musician(getResources().getString(R.string.hjj),getResources().getString(R.string.hjj_detail),R.drawable.hjj));
        mMusicians.add(new Musician(getResources().getString(R.string.zjl),getResources().getString(R.string.zjl_detail),R.drawable.zjl));

        MusicianAdapter musicianAdapter = new MusicianAdapter(this,mMusicians);

        ListView listView = (ListView) findViewById(R.id.musician);

        listView.setAdapter(musicianAdapter);

    }

    /***
     * 初始化专辑页面
     */
    private void creatAlbum(){
        mAlbums.add(new Album(getResources().getString(R.string.album_1),getResources().getString(R.string.songer_1),R.drawable.album1));
        mAlbums.add(new Album(getResources().getString(R.string.album_2),getResources().getString(R.string.songer_2),R.drawable.album2));
        mAlbums.add(new Album(getResources().getString(R.string.album_3),getResources().getString(R.string.songer_3),R.drawable.album3));
        mAlbums.add(new Album(getResources().getString(R.string.album_4),getResources().getString(R.string.songer_4),R.drawable.album4));

        AlbumAdapter albumAdapter = new AlbumAdapter(this,mAlbums);

        GridView gridView = (GridView) findViewById(R.id.album);

        gridView.setAdapter(albumAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,AlbumDetailActivity.class);

                intent.putExtra("albumImage",mAlbums.get(i).getmImgResourseId());
                intent.putExtra("album",mAlbums.get(i).getmAlbumName());
                intent.putExtra("albumSonger",mAlbums.get(i).getmAlbumSonger());

                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    /***
     * 实例化各ArrayList
     */
    private void createObj(){
        //生成推荐歌曲页面
        createRecommandSong();
        //生成音乐人列表
        createMusician();
        //生成专辑列表
        creatAlbum();
    }

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

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        createObj();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


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


}
