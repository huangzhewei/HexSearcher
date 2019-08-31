package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class DouBanVodEntity extends BaseVodRegexEntity {
    public DouBanVodEntity(){
        this.setName("豆瓣资源网");
        this.setVersion("20190831");
        this.setBaseUrl("http://www.doubanzy.com");
        this.setSearchUrl("http://www.doubanzy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.doubanzy.com");
        this.setRuleResultList("<li><a class=\"videoName\"[\\s\\S]*?category[\\s\\S]*?</li>");
        this.setRuleResultLink("href=\"(.*?)\"");
        this.setRuleResultTitle("src=[\\s\\S]*?/>(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("category\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理类", "视频秀"));

        this.setRuleDetailCover("<img src=\"(.*?)\">");
        this.setRuleDetailDesc("剧情介绍</h3>.*?>([\\s\\S]*?)</div>");
        this.setRuleListM3U8("<a>来源：dbm3u8.*?\"playlist wbox\">[\\s\\S]*?</div>");
        this.setRuleList("<li><a title=.*?</a></li>");
        this.setRuleListTitle("_blank\">(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</a>");
    }
}
