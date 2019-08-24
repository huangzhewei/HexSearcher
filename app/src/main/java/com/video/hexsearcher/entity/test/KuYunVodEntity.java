package com.video.hexsearcher.entity.test;


import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;

public class KuYunVodEntity extends BaseVodRegexEntity {
    public KuYunVodEntity() {
        this.setName("酷云资源网");
        this.setVersion("20190824");
        this.setBaseUrl("http://www.kuyunzy.net");
        this.setSearchUrl("http://www.kuyunzy.net/search.asp?page=%page&searchword=%keyWords&searchtype=-1");
        this.setRequestCharset("gb2312");
        this.setResultCharset("gb2312");
        this.setResultLinkHeader("http://www.kuyunzy.net");

        this.setRuleResultList("this\\.className='row1'[\\s\\S]*?</font></td>");
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
