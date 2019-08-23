package com.video.hexsearcher.entity.test;

import com.video.hexsearcher.entity.vod.BaseVodRegexEntity;

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
        this.setRuleResultExtra1("<font .*?>(.*?)</font>");
        this.setRuleResultExtra2("</td>[\\s\\S]*?<td align=\"center\">.*?</td>[\\s\\S]*?<td align=\"center\">(.*?)</td>");
        this.setNewBlockName(Arrays.asList("福利片","伦理片"));

        this.setRuleDetailCover("<img src=\"(.*?)\" alt=[\\s\\S]*?/>");
        this.setRuleDetailDesc("影片介绍开始代码-->([\\s\\S]*?)<\\!");
        this.setRuleListShare("<h1>来源:kkyun[\\s\\S]*?</table>");
        this.setRuleListM3U8("<h1>来源:kkm3u8[\\s\\S]*?</table>");
        this.setRuleListDownList("<h1>来源:xunlei[\\s\\S]*?</table>");
        this.setRuleList("<input.*?value=.*?checked.*?</a>");
        this.setRuleListTitle("<a>(.*?)\\$");
        this.setRuleListLink("\\$(.*?)</a>");
    }
}
