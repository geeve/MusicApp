package com.example.android.musicapp;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

public class RecommandSong {

    /***
     * 歌曲名称
     */
    private String mRecommandSongName;

    /***
     * 推荐歌手
     */
    private String mRecommandSonger;

    /***
     * 构造函数
     * @param recommandSongName 歌曲名称
     * @param recommandSonger   歌曲歌手
     */
    public RecommandSong(String recommandSongName, String recommandSonger){
        this.mRecommandSonger = recommandSonger;
        this.mRecommandSongName = recommandSongName;
    }


    public String getmRecommandSongName(){
        return mRecommandSongName;
    }

    public String getmRecommandSonger(){
        return mRecommandSonger;
    }
}
