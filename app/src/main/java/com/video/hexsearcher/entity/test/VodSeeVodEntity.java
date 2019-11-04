package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class VodSeeVodEntity extends BaseVodRegexEntity {
    public VodSeeVodEntity() {
        this.setName("卧龙资源网");
        this.setVersion("20191001");
        this.setBaseUrl("https://wolongzy.net");
        this.setSearchUrl("https://wolongzy.net/search.html?page=%page&searchword=%keyWords&searchtype=-1");
        this.setResultLinkHeader("https://wolongzy.net");

        this.setRuleResultList("<a class=\"videoName\"[\\s\\S]*?</li>");
        this.setRuleResultLink("href=\"(.*?)\"");
        this.setRuleResultTitle("style=\"width:370px;\">([\\s\\S]*?)(&nbsp|</a>)");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"category\" >(.*?)</span>");
        this.setNewBlockName(Arrays.asList("福利","伦理片"));

        this.setRuleDetailCover("<img src=\"(http://.*?)\">");
        this.setRuleDetailDesc("<h4>剧情介绍</h4>([\\s\\S]*?)</div>");
        this.setRuleListM3U8("<h4><div>WLm3u8</div></h4>[\\s\\S]*?>播放协议");
        this.setRuleList("<input.*?value=.*?checked>");
        this.setRuleListTitle("value=\"(.*?)\\$");
        this.setRuleListLink("\\$(.*?)\"");
    }
}
