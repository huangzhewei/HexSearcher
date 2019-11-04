package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

public class Xl720Entity extends BaseMagRegxEntity {
    public Xl720Entity(){
        this.setName("迅雷电影天堂");
        this.setVersion("20190914");
        this.setBaseUrl("https://www.xl720.com");
        this.setSearchUrl("https://www.xl720.com/page/%page?s=%keyWords");

        this.setRuleResultList("<a class=\"entry-thumb lazyload\"[\\s\\S]*?查看详情");
        this.setRuleResultLink("href=\"(.*?)\"");
        this.setRuleResultTitle("title=\"(.*?)\"");
        this.setRuleResultExtra1("category tag\">(.*?)</a>");
        this.setRuleResultExtra2("<span class=\"date\">(.*?)</span>");

        this.setSecondPage(true);
        this.setRuleDetailList("</i.*?<a href=\".*?\" rel=\"nofollow\" target=\"_blank\" title=\".*?\" >.*?</a></div>");
        this.setRuleDetailTitle(">(.*?)</a>");
        this.setRuleDetailLink("href=\"(.*?)\"");

    }
}
