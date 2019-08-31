package com.video.hexsearcher.entity.test;

import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;
import java.util.Collections;

public class MaoYanVodEntity extends BaseVodRegexEntity {
    public MaoYanVodEntity() {
        this.setName("猫眼资源网");
        this.setVersion("20190831");
        this.setBaseUrl("http://maoyan123.com");
        this.setSearchUrl("http://maoyan123.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        this.setResultLinkHeader("http://maoyan123.com");

        this.setRuleResultList("<li><span class=\"tt\">.*?xing.*?</span></li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Collections.singletonList("伦理片"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        this.setRuleDetailDesc("剧情介绍：.*?vodplayinfo\">([\\s\\S]*?)</div>");
        //this.setRuleListShare("<h3>来源：mbyun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("\"suf\">maoyanm3u8[\\s\\S]*?</ul>");
        this.setRuleList("<li><input.*?value=.*?checked.*?</li>");
        this.setRuleListTitle(">(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}