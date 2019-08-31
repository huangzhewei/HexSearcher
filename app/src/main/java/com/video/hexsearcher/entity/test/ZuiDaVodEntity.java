package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class ZuiDaVodEntity extends BaseVodRegexEntity {
    public ZuiDaVodEntity() {
        this.setName("最大资源网");
        this.setVersion("20190824");
        this.setBaseUrl("http://www.zuidazy1.net");
        this.setSearchUrl("http://www.zuidazy1.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        this.setResultLinkHeader("http://www.zuidazy1.net");

        this.setRuleResultList("<li><span class=\"tt\">.*?xing_vb.*?</li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("xing_vb.*?xing_vb.*?.*?xing_vb.*?\">(.*?)</span></li>");
        this.setRuleResultExtra2("xing_vb.*?.*?xing_vb.*?\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("福利片","伦理片"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        this.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        //this.setRuleListShare("<div id=\"play_2\">[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<div id=\"play_1\">[\\s\\S]*?</ul>");
        this.setRuleListDownList("<div id=\"down_1\">[\\s\\S]*?</ul>");
        this.setRuleList("<li><input.*?value=.*?checked.*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
