package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

import java.util.Arrays;

public class WiKiEntity extends BaseMagRegxEntity {
    public WiKiEntity(){
        this.setName("磁力WiKi");
        this.setVersion("20190904");
        this.setBaseUrl("https://www.ciliwiki.com");
        this.setSearchUrl("https://www.ciliwiki.com/search/%keyWords-%page-time.html");
        this.setRuleResultList("item-title\">[\\s\\S]*?<span>下");
        this.setResultLinkHeader("magnet:?xt=urn:btih:");
        this.setRuleResultLink("/hash/(.*?).html");
        this.setRuleResultTitle("_blank\">(.*?)</a>");
        this.setRuleResultExtra1("(\\d\\S*?前)");
        this.setRuleResultExtra2("(\\d*\\.\\d*\\s[a-zA-Z])");
    }
}
