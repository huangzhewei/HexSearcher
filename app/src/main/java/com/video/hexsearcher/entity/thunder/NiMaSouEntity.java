package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;
import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import java.util.Arrays;
import java.util.Collections;

public class NiMaSouEntity extends BaseMagRegxEntity {
    public NiMaSouEntity(){
        this.setName("尼玛搜");
        this.setVersion("20190904");
        this.setBaseUrl("http://www.nms000.com");
        this.setSearchUrl("http://www.nms000.com/l/%keyWords-first-asc-%page");
        this.setRuleResultList("<td class=\"x-item\">[\\s\\S]*?<tr>");
        this.setRuleResultLink("(magnet:\\?xt=urn:btih:[a-zA-z0-9]{40})");
        this.setRuleResultTitle("href=\"/v/.*?\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("(\\d*\\.\\d*\\s[a-zA-])");
        this.setReplaceWords(Arrays.asList("群[0-9]{5,11}","官方QQ群：[0-9]{5,11}"));
    }
}
