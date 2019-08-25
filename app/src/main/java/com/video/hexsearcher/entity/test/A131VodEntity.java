package com.video.hexsearcher.entity.test;

import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class A131VodEntity extends BaseVodRegexEntity {
    public A131VodEntity() {
        this.setName("131资源网");
        this.setVersion("20190825");
        this.setBaseUrl("http://131zy.vip");
        this.setSearchUrl("http://131zy.vip/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        this.setRequestCharset("utf-8");
        this.setResultCharset("utf-8");
        this.setResultLinkHeader("http://131zy.vip");

        this.setRuleResultList("<li><span class=\"tt\">.*?xing.*?</span></li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理片","视频秀"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        this.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        this.setRuleListShare("<h3>来源：131zy</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>来源：131m3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleListDownList("");
        this.setRuleList("<input.*?value=.*?checked.*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
