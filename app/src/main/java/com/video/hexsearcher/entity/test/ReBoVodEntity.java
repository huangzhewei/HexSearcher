package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;
import java.util.Collections;

public class ReBoVodEntity extends BaseVodRegexEntity {
    public ReBoVodEntity() {
        this.setName("热播资源网");
        this.setVersion("20191001");
        this.setBaseUrl("https://rebozy.com");
        this.setSearchUrl("https://rebozy.com/index.php/vod/search/page/%page/wd/%keyWords.html");
        this.setResultLinkHeader("https://rebozy.com");

        this.setRuleResultList("<li class=\"clearfix\">[\\s\\S]*?</li>");
        this.setRuleResultLink("<a href=\"(.*?)\" title");
        this.setRuleResultTitle("title=\".*?\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"type\">[\\s\\S]*?<a href=\".*?\">(.*?)</a>[\\s\\S]*?</span>");
        this.setNewBlockName(Collections.singletonList("伦理片"));

        this.setRuleDetailCoverHeader("https://rebozy.com");
        this.setRuleDetailCover("<img class=\"img-responsive\" src=\"(.*?)\"");
        this.setRuleDetailDesc("<!-- 剧情 -->([\\s\\S]*?)<!-- end 剧情 -->");
        this.setRuleListM3U8("播放类型：.*?rem3u8[\\s\\S]*?</ul>");
        this.setRuleList("<input type=\"checkbox\".*?value=\".*?\\$.*?\" checked>");
        this.setRuleListTitle("value=\"(.*?)\\$");
        this.setRuleListLink("\\$(.*?)\"");
    }
}
