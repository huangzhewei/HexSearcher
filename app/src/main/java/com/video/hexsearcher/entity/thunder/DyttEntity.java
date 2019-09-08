package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;
import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;
import java.util.Collections;

public class DyttEntity extends BaseMagRegxEntity {
    public DyttEntity(){
        this.setName("电影天堂");
        this.setVersion("20190908");
        this.setBaseUrl("http://s.ygdy8.com");
        this.setSearchUrl("http://s.ygdy8.com/plus/so.php?typeid=1&keyword=%keyWords&PageNo=%page");
        this.setRequestCharset("gb2312");
        this.setResultCharset("gb2312");

        this.setResultLinkHeader("http://walixiwa.club:455/curl/c.php?url=https://www.ygdy8.com");
        this.setRuleResultList("file.gif\"[\\s\\S]*?<td height=.*?>[\\s\\S]*?</td>");
        this.setRuleResultLink("<a href='(.*?)'>");
        this.setRuleResultTitle("<a href='.*?'>(.*?)</td>");
        this.setRuleResultExtra1("(◎年\\s*代\\s*\\d{4}|\\d{4}\\s*年|\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("colspan='3'>([\\s\\S]*?)</td>");

        this.setSecondPage(true);
        this.setRuleDetailList("<td style=\"WORD-WRAP:.*?><a href=\".*?\">.*?</a></td>");
        this.setRuleDetailTitle(">(.*?)</a>");
        this.setRuleDetailLink("<a href=\"(.*?)\">");

    }
}
