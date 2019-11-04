package com.walixiwa.vodhunter.thunder;

import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class BaseMagItemEntity implements Serializable {
    private String resultTitle = "";
    private String resultLink = "";
    private String resultExtra1 = "";
    private String resultExtra2 = "";
    private String resultExtra3 = "";
    private String resultExtra4 = "";
    private BaseMagRegxEntity baseMagRegxEntity;

    public String getResultTitle() {
        return resultTitle;
    }

    public void setResultTitle(String resultTitle) {
        this.resultTitle = resultTitle;
    }

    public String getResultLink() {
        return resultLink;
    }

    public void setResultLink(String resultLink) {
        this.resultLink = resultLink;
    }

    public String getResultExtra1() {
        return resultExtra1;
    }

    public void setResultExtra1(String resultExtra1) {
        this.resultExtra1 = resultExtra1;
    }

    public String getResultExtra2() {
        return resultExtra2;
    }

    public void setResultExtra2(String resultExtra2) {
        this.resultExtra2 = resultExtra2;
    }

    public String getResultExtra3() {
        return resultExtra3;
    }

    public void setResultExtra3(String resultExtra3) {
        this.resultExtra3 = resultExtra3;
    }

    public String getResultExtra4() {
        return resultExtra4;
    }

    public void setResultExtra4(String resultExtra4) {
        this.resultExtra4 = resultExtra4;
    }

    public BaseMagRegxEntity getBaseMagRegxEntity() {
        return baseMagRegxEntity;
    }

    public void setBaseMagRegxEntity(BaseMagRegxEntity baseMagRegxEntity) {
        this.baseMagRegxEntity = baseMagRegxEntity;
    }

    public String toJsonString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("resultTitle", resultTitle);
            jsonObject.put("resultLink", resultLink);
            jsonObject.put("resultExtra1", resultExtra1);
            jsonObject.put("resultExtra2", resultExtra2);
            jsonObject.put("resultExtra3", resultExtra3);
            jsonObject.put("resultExtra4", resultExtra4);
            jsonObject.put("baseMagRegxEntity", baseMagRegxEntity.toBase64Linker());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public BaseMagItemEntity() {
    }

    public BaseMagItemEntity(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            this.resultTitle = getString(jsonObject, "resultTitle");
            this.resultLink = getString(jsonObject, "resultLink");
            this.resultExtra1 = getString(jsonObject, "resultExtra1");
            this.resultExtra2 = getString(jsonObject, "resultExtra2");
            this.resultExtra3 = getString(jsonObject, "resultExtra3");
            this.resultExtra4 = getString(jsonObject, "resultExtra4");
            this.baseMagRegxEntity = new BaseMagRegxEntity(getString(jsonObject, "baseVodRegexEntity"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getString(JSONObject jsonObject, String key) {
        if (jsonObject.has(key)) {
            try {
                return jsonObject.getString(key);
            } catch (JSONException e) {
                return "";
            }
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        return "BaseVodItemEntity{" +
                "resultTitle='" + resultTitle + '\'' +
                ", resultLink='" + resultLink + '\'' +
                ", resultExtra1='" + resultExtra1 + '\'' +
                ", resultExtra2='" + resultExtra2 + '\'' +
                ", resultExtra3='" + resultExtra3 + '\'' +
                ", resultExtra4='" + resultExtra4 + '\'' +
                ", baseVodRegexEntity=" + baseMagRegxEntity +
                '}';
    }
}
