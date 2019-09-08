package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

import java.util.Collections;

public class A7MeEntity extends BaseMagRegxEntity {
    public A7MeEntity(){
        this.setName("磁力管家");
        this.setVersion("20190904");
        this.setBaseUrl("https://7pp.me");
        this.setSearchUrl("https://7pp.me/search-%keyWords-1-%page-1.html");
        this.setRuleResultList("<dl class=\"detail\">[\\s\\S]*?<ul class=\"filelist\">");
        this.setRuleResultLink("(magnet:\\?xt=urn:btih:[a-zA-Z0-9]{40})");
        this.setRuleResultTitle("_blank\">(.*?)</a></dt>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("(\\d*\\.\\d*\\s[a-zA-Z])");
        this.setReplaceWords(Collections.singletonList("\\[email.*?\\]"));
    }
}
