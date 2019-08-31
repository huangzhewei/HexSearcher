package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class BaiWanVodEntity extends BaseVodRegexEntity {
    public BaiWanVodEntity(){
        this.setName("百万资源网");
        this.setVersion("20190831");
        this.setBaseUrl("http://www.baiwanzy.com");
        this.setSearchUrl("http://www.baiwanzy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.baiwanzy.com");
        this.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        this.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)<a href");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理片", "美女视频"));

        this.setRuleDetailCoverHeader("http://www.baiwanzy.com");
        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        this.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        //this.setRuleListShare("<h3>来源：bwyun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>来源：bwm3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleList("<input .*?\\$.*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
