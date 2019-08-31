package com.video.hexsearcher.entity.test;

import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class MiaoBoVodEntity extends BaseVodRegexEntity {
    public MiaoBoVodEntity() {
        this.setName("秒播资源网");
        this.setVersion("20190829");
        this.setBaseUrl("http://www.mbkkk.com");
        this.setSearchUrl("http://www.mbkkk.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        this.setRequestCharset("utf-8");
        this.setResultCharset("utf-8");
        this.setResultLinkHeader("http://www.mbkkk.com");

        this.setRuleResultList("<li><span class=\"tt\">.*?xing.*?</span></li>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("<span class=\"xing_vb5\">(.*?)</span>");
        this.setNewBlockName(Arrays.asList("伦理片","福利视频"));

        this.setRuleDetailCoverHeader("http://www.mbkkk.com");
        this.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        this.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        //this.setRuleListShare("<h3>来源：mbyun</h3>[\\s\\S]*?</ul>");
        this.setRuleListM3U8("<h3>来源：mbckm3u8</h3>[\\s\\S]*?</ul>");
        this.setRuleList("<input.*?value=.*?checked.*?</li>");
        this.setRuleListTitle("target=\"_blank\" />(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</li>");
    }
}
