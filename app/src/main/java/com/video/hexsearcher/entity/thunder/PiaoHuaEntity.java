package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

public class PiaoHuaEntity extends BaseMagRegxEntity {
    public PiaoHuaEntity(){
        this.setName("飘花电影");
        this.setVersion("20190906");
        this.setBaseUrl("https://www.piaohua.com");
        this.setSearchUrl("https://www.piaohua.com/plus/search.php?kwtype=0&keyword=%keyWords&PageNo=%page");

        this.setResultLinkHeader("https://www.piaohua.com");
        this.setRuleResultList("<li class=\"col-md-6\">[\\s\\S]*?</li>");
        this.setRuleResultLink("<h3><a href=\"(.*?)\">");
        this.setRuleResultTitle("<h3><a href=\".*?\">(.*?)</a></h3>");
        this.setRuleResultExtra1("_blank\">(.*?)</a>");
        this.setRuleResultExtra2("(\\d{4}-\\d{2}-\\d{2})");

        this.setSecondPage(true);
        this.setRuleDetailList("(magnet:\\?xt=urn:btih:[a-zA-Z0-9]{40}|(ftp://.*?\\.(avi|rmvb|mkv|mp4)))");
        this.setRuleDetailTitle("([^/]+(?!.*/))");
        this.setRuleDetailLink("(magnet:\\?xt=urn:btih:[a-zA-Z0-9]{40}|(ftp://.*?\\.(avi|rmvb|mkv|mp4)))");

    }
}
