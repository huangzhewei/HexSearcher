package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class KuBoVodEntity extends BaseVodRegexEntity {
    public KuBoVodEntity(){
        this.setName("酷播资源网");
        this.setVersion("20190831");
        this.setBaseUrl("http://www.kubozy.net");
        this.setSearchUrl("http://www.kubozy.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.kubozy.net");
        this.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理片", "福利"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        this.setRuleDetailDesc("剧情介绍：[\\s\\S]*?vodplayinfo\">([\\s\\S]*?)</div>");
        //this.setRuleListShare("\"suf\">kuyun[\\s\\S]*?</ul>");
        this.setRuleListM3U8("\"suf\">kakam3u8[\\s\\S]*?</ul>");
        this.setRuleList("<input .*?\\$.*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
