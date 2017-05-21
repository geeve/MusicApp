package com.example.android.musicapp;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

public class Musician {

    //存放歌手名称
    private String mMusicianSongerName;
    //存放歌手详细情况
    private String mMusicianSongDetail;
    //存放歌手图片资源ID
    private int mImageResourseId;


    /***
     * 构造函数
     * @param musicianSongerName 歌手名字
     * @param musicianSongDetail 歌手详细
     * @param imageResourseId    歌手图片资源ID
     */
    public Musician(String musicianSongerName,String musicianSongDetail,int imageResourseId){
        this.mImageResourseId = imageResourseId;
        this.mMusicianSongDetail = musicianSongDetail;
        this.mMusicianSongerName = musicianSongerName;
    }


    public String getmMusicianSongerName(){
        return mMusicianSongerName;
    }

    public String getmMusicianSongDetail(){
        return  mMusicianSongDetail;
    }

    public int getmImageResourseId(){
        return mImageResourseId;
    }
}
