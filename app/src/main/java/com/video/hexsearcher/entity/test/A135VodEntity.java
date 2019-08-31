package com.video.hexsearcher.entity.test;

import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class A135VodEntity extends BaseVodRegexEntity {
    public A135VodEntity() {
        this.setName("135资源网");
        this.setVersion("20190831");
        this.setBaseUrl("http://135zy.cc");
        this.setSearchUrl("http://135zy.cc/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        this.setRequestCharset("utf-8");
        this.setResultCharset("utf-8");
        this.setResultLinkHeader("http://135zy.cc");

        this.setRuleResultList("<li><span class=\"tt\">.*?xing.*?</span></li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理片","热舞写真"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        this.setRuleDetailDesc("剧情介绍：.*?vodplayinfo\">([\\s\\S]*?)</div>");
        //this.setRuleListShare("<h3>来源：mbyun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>来源：135m3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleList("<input.*?value=.*?checked.*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
