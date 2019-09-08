package com.walixiwa.vodhunter.thunder;

import java.io.Serializable;

public class BaseMagDetailEntity implements Serializable {
    private String title;
    private String link;

    public BaseMagDetailEntity() {
    }

    public BaseMagDetailEntity(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
