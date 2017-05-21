package com.example.android.musicapp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/21 0021.
 */


public class Album {
    //存放专辑名称
    private String mAlbumName;
    //专辑歌手
    private String mAlbumSonger;
    //专辑图片资源
    private int mImgResourseId;


    /**
     * 构造函数
     * @param albumName 专辑名
     * @param albumSonger 专辑歌手
     * @param imgResourseId 专辑图片
     */
    public Album(String albumName, String albumSonger, int imgResourseId){

        this.mAlbumName = albumName;
        this.mAlbumSonger = albumSonger;
        this.mImgResourseId = imgResourseId;

    }


    public String getmAlbumName(){
        return mAlbumName;
    }

    public String getmAlbumSonger(){
        return mAlbumSonger;
    }

    public int getmImgResourseId(){
        return mImgResourseId;
    }
}
