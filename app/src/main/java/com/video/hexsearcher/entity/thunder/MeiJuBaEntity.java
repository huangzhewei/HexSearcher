package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

public class MeiJuBaEntity extends BaseMagRegxEntity {
    public MeiJuBaEntity(){
        this.setName("美剧吧");
        this.setVersion("20190912");
        this.setBaseUrl("http://www.meiju8.cc");
        this.setSearchUrl("http://www.meiju8.cc/search.php?kw=%keyWords&p=%page");

        this.setResultLinkHeader("http://www.meiju8.cc");
        this.setRuleResultList("<ul class=\"list_20\">[\\s\\S]*?</ul>");
        this.setRuleResultLink("<a href=\"(.*?)\"");
        this.setRuleResultTitle("title=\"(.*?)\">");
        this.setRuleResultExtra1("(\\d{4}年)");
        this.setRuleResultExtra2("状态：(.*?)</li>");

        this.setSecondPage(true);
        this.setRuleDetailList("source-url=\".*?\">.*?</a>");
        this.setRuleDetailTitle(">(.*?)</a>");
        this.setRuleDetailLink("source-url=\"(.*?)\"");

    }
}
