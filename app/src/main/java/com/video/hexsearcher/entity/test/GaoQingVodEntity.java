package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;
import java.util.Collections;

public class GaoQingVodEntity extends BaseVodRegexEntity {
    public GaoQingVodEntity(){
        this.setName("高清资源网");
        this.setVersion("20190831");
        this.setBaseUrl("http://www.gaoqingzy.com");
        this.setSearchUrl("http://www.gaoqingzy.com/?m=vod-index-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.gaoqingzy.com");
        this.setRuleResultList("<ul class=\"nr\">[\\s\\S]*?</ul>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("class=\"name\"> [&nbsp;]*(.*?)<font");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("class=\"btn_span\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理片","美女写真"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        this.setRuleDetailDesc("心情开始 -->([\\s\\S]*?)<\\!");
        this.setRuleListM3U8("播放类型：gqm3u8[\\s\\S]*?</ul>");
        this.setRuleList("<li>[\\s\\S]*?\\$[\\s\\S]*?</li>");
        this.setRuleListTitle("<li>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
