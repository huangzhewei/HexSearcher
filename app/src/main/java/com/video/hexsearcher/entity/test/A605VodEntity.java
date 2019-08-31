package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;
import java.util.Collections;

public class A605VodEntity extends BaseVodRegexEntity {
    public A605VodEntity(){
        this.setName("605资源网");
        this.setVersion("20190829");
        this.setBaseUrl("http://605zy.com");
        this.setSearchUrl("http://605zy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://605zy.com");
        this.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        this.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Collections.singletonList("伦理"));

        this.setRuleDetailCoverHeader("http://605zy.com");
        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        this.setRuleDetailDesc("介绍：[\\s\\S]*?<div class=\"vodplayinfo\">([\\s\\S]*?)</div>");
        //this.setRuleListShare("<h3>来源：605yun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>来源：605m3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleList("<input .*?\\$.*?</a></li>");
        this.setRuleListTitle("target=\"_blank\">(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</a>");
    }
}
