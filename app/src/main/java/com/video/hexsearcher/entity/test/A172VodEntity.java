package com.video.hexsearcher.entity.test;

import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class A172VodEntity extends BaseVodRegexEntity {
    public A172VodEntity() {
        this.setName("172资源网");
        this.setVersion("20190825");
        this.setBaseUrl("http://www.172zy.net");
        this.setSearchUrl("http://www.172zy.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        this.setRequestCharset("utf-8");
        this.setResultCharset("utf-8");
        this.setResultLinkHeader("http://www.172zy.net");

        this.setRuleResultList("<li><span class=\"tt\">.*?xing.*?</a></li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)<img class");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb51\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("福利片","伦理片"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        this.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        this.setRuleListShare("<h3>来源：172m3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>来源：172zy</h3>[\\s\\S]*?</ul>");
        this.setRuleListDownList("");
        this.setRuleList("<input.*?value=.*?checked.*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
