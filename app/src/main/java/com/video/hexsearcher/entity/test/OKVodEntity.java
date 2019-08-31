package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class OKVodEntity extends BaseVodRegexEntity {
    public OKVodEntity(){
        this.setName("OK资源网");
        this.setVersion("20190824");
        this.setBaseUrl("http://www.okzyw.com");
        this.setSearchUrl("http://www.okzyw.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.okzyw.com");
        this.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("<span class=\"xing_vb6\">(.*?)</span>");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("福利片","伦理片"));

        this.setRuleDetailCover("<div class=\"vodImg\">[\\s\\S]*?src=\"(.*?)\"");
        this.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        //this.setRuleListShare("<div id=\"1\">[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<div id=\"2\">[\\s\\S]*?</ul>");
        this.setRuleListDownList("<div id=\"down_1\">[\\s\\S]*?</ul>");
        this.setRuleList("name=\"copy_sel\" value=[\\s\\S]*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
