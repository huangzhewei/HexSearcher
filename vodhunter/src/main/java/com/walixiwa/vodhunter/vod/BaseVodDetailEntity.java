package com.walixiwa.vodhunter.vod;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BaseVodDetailEntity {
    private String cover;
    private String desc;
    private List<BaseVodPlayEntity> m3u8List = new ArrayList<>();
    private List<BaseVodPlayEntity> shareList = new ArrayList<>();
    private List<BaseVodPlayEntity> downList = new ArrayList<>();

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<BaseVodPlayEntity> getM3u8List() {
        return m3u8List;
    }

    public void setM3u8List(List<BaseVodPlayEntity> m3u8List) {
        this.m3u8List = m3u8List;
    }

    public List<BaseVodPlayEntity> getShareList() {
        return shareList;
    }

    public void setShareList(List<BaseVodPlayEntity> shareList) {
        this.shareList = shareList;
    }

    public List<BaseVodPlayEntity> getDownList() {
        return downList;
    }

    public void setDownList(List<BaseVodPlayEntity> downList) {
        this.downList = downList;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
