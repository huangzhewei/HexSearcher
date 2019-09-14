package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

public class KanTianTangEntity extends BaseMagRegxEntity {
    public KanTianTangEntity(){
        this.setName("电影2046");
        this.setVersion("20190913");
        this.setRequestCharset("gb2312");
        this.setResultCharset("gb2312");
        this.setBaseUrl("http://www.dy2046.net");
        this.setSearchUrl("http://www.dy2046.net/search.asp?page=%page&searchword=%keyWords&searchtype=-1");
        this.setResultLinkHeader("http://www.dy2046.net");
        this.setRuleResultList("<p>主演：[\\s\\S]*?</h1>");
        this.setRuleResultLink("<a href=\"(.*?)#kan\">");
        this.setRuleResultTitle("<a href=\".*?\">(.*?)</h1>");
        this.setRuleResultExtra1("(<b>类型：.*?</b>)");
        this.setRuleResultExtra2("(<b>更新：.*?</b>)");

        this.setSecondPage(true);
        this.setRuleDetailList("class=\"down_url\" value=\".*?\" file_name=\".*?\"");
        this.setRuleDetailTitle("file_name=\"(.*?)\"");
        this.setRuleDetailLink("value=\"(.*?)\"");

    }
}
