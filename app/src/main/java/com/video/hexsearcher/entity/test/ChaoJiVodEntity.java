package com.video.hexsearcher.entity.test;

import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class ChaoJiVodEntity extends BaseVodRegexEntity {
    public ChaoJiVodEntity() {
        this.setName("超级资源网");
        this.setVersion("20190829");
        this.setBaseUrl("http://chaojizy.com");
        this.setSearchUrl("http://chaojizy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        this.setRequestCharset("utf-8");
        this.setResultCharset("utf-8");
        this.setResultLinkHeader("http://chaojizy.com");

        this.setRuleResultList("<li><span class=\"tt\">.*?xing.*?</span></li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理片","福利视频"));

        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        this.setRuleDetailDesc("剧情介绍：</strong></div><div class=\"vodplayinfo\">([\\s\\S]*?)</div>");
        //this.setRuleListShare("<h3>播放类型：cjyun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>播放类型：cjm3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleList("<input.*?value=.*?checked.*?</li>");
        this.setRuleListTitle("target=\"_blank\">(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</a></li>");
    }
}
