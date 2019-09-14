package com.video.hexsearcher.entity.thunder;


import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

public class QiQiPuEntity extends BaseMagRegxEntity {
    public QiQiPuEntity(){
        this.setName("七七铺");
        this.setVersion("20190913");
        this.setRequestCharset("gb2312");
        this.setResultCharset("gb2312");
        this.setBaseUrl("http://www.qiqipu.tv");
        this.setSearchUrl("http://www.qiqipu.tv/search.asp?page=%page&searchword=%keyWords&searchtype=-1");
        this.setResultLinkHeader("http://www.qiqipu.tv");
        this.setRuleResultList("<li><a href=[\\s\\S]*?btn_play[\\s\\S]*?</li>");
        this.setRuleResultLink("<h2><a href=\"(.*?)\"");
        this.setRuleResultTitle("<h2><a href=\".*?\">(.*?)</h2>");
        this.setRuleResultExtra1("(<span>类型：.*?</span>)");
        this.setRuleResultExtra2("(<p>主演：.*?</p>)");

        this.setSecondPage(true);
        this.setRuleDetailList("value=\".*?\" file_name=\".*?\"");
        this.setRuleDetailTitle("file_name=\"(.*?)\"");
        this.setRuleDetailLink("value=\"(.*?)\"");

    }
}
