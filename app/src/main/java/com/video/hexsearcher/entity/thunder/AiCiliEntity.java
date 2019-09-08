package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

public class AiCiliEntity extends BaseMagRegxEntity {
    public AiCiliEntity(){
        this.setName("爱磁力");
        this.setVersion("20190904");
        this.setBaseUrl("http://www.aicili.net");
        this.setSearchUrl("http://www.aicili.net/main-search-kw-%keyWords-px-1-page-%page.html");
        this.setRuleResultList("<div class=\"panel-body\">[\\s\\S]*?</tr>");
        this.setResultLinkHeader("http://www.aicili.net");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("_blank\">(.*?)</a>.*?</h5>");
        this.setRuleResultExtra1("(\\d{4}-\\d{2}-\\d{2})");
        this.setRuleResultExtra2("(\\d*\\.\\d*GB)");
        this.setSecondPage(true);
        this.setRuleDetailLink("(magnet:\\?xt=urn:btih:[a-zA-Z0-9]{40})");
    }
}
