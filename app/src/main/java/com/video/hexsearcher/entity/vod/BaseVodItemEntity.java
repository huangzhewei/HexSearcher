package com.video.hexsearcher.entity.vod;

import com.google.gson.Gson;

public class BaseVodItemEntity {
    private String resultTitle;
    private String resultLink;
    private String resultExtra1;
    private String resultExtra2;
    private String resultExtra3;
    private String resultExtra4;
    private BaseVodRegexEntity baseVodRegexEntity;

    public String getResultTitle() {
        return resultTitle;
    }

    public void setResultTitle(String resultTitle) {
        this.resultTitle = resultTitle;
    }

    public String getResultLink() {
        return resultLink;
    }

    public void setResultLink(String resultLink) {
        this.resultLink = resultLink;
    }

    public String getResultExtra1() {
        return resultExtra1;
    }

    public void setResultExtra1(String resultExtra1) {
        this.resultExtra1 = resultExtra1;
    }

    public String getResultExtra2() {
        return resultExtra2;
    }

    public void setResultExtra2(String resultExtra2) {
        this.resultExtra2 = resultExtra2;
    }

    public String getResultExtra3() {
        return resultExtra3;
    }

    public void setResultExtra3(String resultExtra3) {
        this.resultExtra3 = resultExtra3;
    }

    public String getResultExtra4() {
        return resultExtra4;
    }

    public void setResultExtra4(String resultExtra4) {
        this.resultExtra4 = resultExtra4;
    }

    public BaseVodRegexEntity getBaseVodRegexEntity() {
        return baseVodRegexEntity;
    }

    public void setBaseVodRegexEntity(BaseVodRegexEntity baseVodRegexEntity) {
        this.baseVodRegexEntity = baseVodRegexEntity;
    }

    @Override
    public String toString() {
        return "BaseVodItemEntity{" +
                "resultTitle='" + resultTitle + '\'' +
                ", resultLink='" + resultLink + '\'' +
                ", resultExtra1='" + resultExtra1 + '\'' +
                ", resultExtra2='" + resultExtra2 + '\'' +
                ", resultExtra3='" + resultExtra3 + '\'' +
                ", resultExtra4='" + resultExtra4 + '\'' +
                '}';
    }
}
