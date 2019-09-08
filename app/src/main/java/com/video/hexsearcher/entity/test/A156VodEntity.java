package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;
import java.util.Collections;

public class A156VodEntity extends BaseVodRegexEntity {
    public A156VodEntity(){
        this.setName("156资源网");
        this.setVersion("20190907");
        this.setBaseUrl("http://www.156zy.co");
        this.setSearchUrl("http://www.156zy.co/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.156zy.co");
        this.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        this.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        this.setRuleResultTitle("_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理类","视讯美女"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        this.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        //this.setRuleListShare("<h3>来源：605yun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>来源：33uuck</h3>[\\s\\S]*?</ul>");
        this.setRuleList("<input .*?\\$.*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
