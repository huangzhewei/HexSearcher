package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class SuBoVodEntity extends BaseVodRegexEntity {
    public SuBoVodEntity(){
        this.setName("速播资源网");
        this.setVersion("20190830");
        this.setBaseUrl("http://www.subo988.com");
        this.setSearchUrl("http://www.subo988.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");

        this.setResultLinkHeader("http://www.subo988.com");
        this.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        this.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("理论片", "福利片"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        this.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        //this.setRuleListShare("<h3>播放类型：suboyun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>播放类型：subom3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleList("<input .*?\\$.*?</li>");
        this.setRuleListTitle("/>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
