package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;
import java.util.Collections;

public class A123VodEntity extends BaseVodRegexEntity {
    public A123VodEntity(){
        this.setName("123资源网");
        this.setVersion("20190831");
        this.setBaseUrl("http://www.123ku.com");
        this.setSearchUrl("http://www.123ku.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.123ku.com");
        this.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Collections.singletonList("论理片"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        this.setRuleDetailDesc("<\\!--介绍开始-->([\\s\\S]*?)<\\!--介绍结束-->");
        //this.setRuleListShare("<h3>播放类型：xinyun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<div id=\"play_1\">[\\s\\S]*?</ul>");
        this.setRuleList("<input .*?\\$.*?</li>");
        this.setRuleListTitle("_black\">(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</a>");
    }
}
