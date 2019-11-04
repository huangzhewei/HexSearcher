package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class JiSuVodEntity extends BaseVodRegexEntity {
    public JiSuVodEntity(){
        this.setName("极速云资源网");
        this.setVersion("20190914");
        this.setBaseUrl("http://www.caijizy.com");
        this.setSearchUrl("http://www.caijizy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.caijizy.com");
        this.setRuleResultList("<tr class=\"DianDian\"[\\s\\S]*?</tr>");
        this.setRuleResultLink("<td class=\"l\"><a href=\"(.*?)\"");
        this.setRuleResultTitle("<td class=\"l\"><a href=\".*?\" target=\"_blank\">(.*?)</font>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("target=\"_blank\">(.*?)</a>");
        this.setNewBlockName(Arrays.asList("伦理片", "美女视频","VIP视频","美女写真"));

        this.setRuleDetailCover("<img src=\"(.*?)\"/>");
        this.setRuleDetailDesc("<!--简介开始-->([\\s\\S]*?)<!--简介结束-->");
        //this.setRuleListShare("\"suf\">kuyun[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<!--前jsm3u8-->[\\s\\S]*?<!--后jsm3u8-->");
        this.setRuleList("<li><input.*?value=\".*?\\$.*?</li>");
        this.setRuleListTitle("<span>(.*?)\\$");
        this.setRuleListLink("\\$</span>(.*?)</li>");
    }
}
