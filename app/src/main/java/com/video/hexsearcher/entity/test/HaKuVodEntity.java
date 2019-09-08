package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class HaKuVodEntity extends BaseVodRegexEntity {
    public HaKuVodEntity(){
        this.setName("哈酷资源网");
        this.setVersion("20190907");
        this.setBaseUrl("http://666zy.com");
        this.setSearchUrl("http://666zy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://666zy.com");
        this.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        this.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("写真","伦理"));

        this.setRuleDetailCoverHeader("http://666zy.com");
        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        this.setRuleDetailDesc("介绍：[\\s\\S]*?<div class=\"vodplayinfo\">([\\s\\S]*?)</div>");
        //this.setRuleListShare("<h3>来源：hkzy</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>来源：hkm3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleList("<li><a href=\".*?\" target=\"_blank\">.*?\\$.*?</a></li>");
        this.setRuleListTitle("target=\"_blank\">(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</a>");
    }
}
