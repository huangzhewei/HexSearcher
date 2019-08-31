package com.walixiwa.vodhunter.vod;

import android.text.TextUtils;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseVodRegexEntity implements Serializable {
    private String name = "";
    private String version = "";
    private String requestCharset = "";
    private String resultCharset = "";
    private String userAgent = "";
    private String baseUrl = "";
    private String searchUrl = "";
    private String resultLinkHeader = "";
    private String ruleResultList = "";
    private String ruleResultLink = "";
    private String ruleResultTitle = "";
    private String ruleResultExtra1 = "";
    private String ruleResultExtra2 = "";
    private String ruleResultExtra3 = "";
    private String ruleResultExtra4 = "";
    private String ruleDetailCoverHeader = "";
    private String ruleDetailCover = "";
    private String ruleDetailDesc = "";
    private String ruleListM3U8 = "";
    private String ruleListShare = "";
    private String ruleListDownList = "";
    private String ruleList = "";
    private String ruleListTitle = "";
    private String ruleListLink = "";
    private List<String> newNameJson = new ArrayList<>();
    private List<String> newLinkJson = new ArrayList<>();
    private List<String> newBlockName = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRequestCharset() {
        return requestCharset;
    }

    public void setRequestCharset(String requestCharset) {
        this.requestCharset = requestCharset;
    }

    public String getResultCharset() {
        return resultCharset;
    }

    public void setResultCharset(String resultCharset) {
        this.resultCharset = resultCharset;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getResultLinkHeader() {
        return resultLinkHeader;
    }

    public void setResultLinkHeader(String resultLinkHeader) {
        this.resultLinkHeader = resultLinkHeader;
    }

    public String getRuleResultList() {
        return ruleResultList;
    }

    public void setRuleResultList(String ruleResultList) {
        this.ruleResultList = ruleResultList;
    }

    public String getRuleResultLink() {
        return ruleResultLink;
    }

    public void setRuleResultLink(String ruleResultLink) {
        this.ruleResultLink = ruleResultLink;
    }

    public String getRuleResultTitle() {
        return ruleResultTitle;
    }

    public void setRuleResultTitle(String ruleResultTitle) {
        this.ruleResultTitle = ruleResultTitle;
    }

    public String getRuleResultExtra1() {
        return ruleResultExtra1;
    }

    public void setRuleResultExtra1(String ruleResultExtra1) {
        this.ruleResultExtra1 = ruleResultExtra1;
    }

    public String getRuleResultExtra2() {
        return ruleResultExtra2;
    }

    public void setRuleResultExtra2(String ruleResultExtra2) {
        this.ruleResultExtra2 = ruleResultExtra2;
    }

    public String getRuleResultExtra3() {
        return ruleResultExtra3;
    }

    public void setRuleResultExtra3(String ruleResultExtra3) {
        this.ruleResultExtra3 = ruleResultExtra3;
    }

    public String getRuleResultExtra4() {
        return ruleResultExtra4;
    }

    public void setRuleResultExtra4(String ruleResultExtra4) {
        this.ruleResultExtra4 = ruleResultExtra4;
    }

    public String getRuleDetailCoverHeader() {
        return ruleDetailCoverHeader;
    }

    public void setRuleDetailCoverHeader(String ruleDetailCoverHeader) {
        this.ruleDetailCoverHeader = ruleDetailCoverHeader;
    }

    public String getRuleDetailCover() {
        return ruleDetailCover;
    }

    public void setRuleDetailCover(String ruleDetailCover) {
        this.ruleDetailCover = ruleDetailCover;
    }

    public String getRuleDetailDesc() {
        return ruleDetailDesc;
    }

    public void setRuleDetailDesc(String ruleDetailDesc) {
        this.ruleDetailDesc = ruleDetailDesc;
    }

    public String getRuleListM3U8() {
        return ruleListM3U8;
    }

    public void setRuleListM3U8(String rulelistM3U8) {
        this.ruleListM3U8 = rulelistM3U8;
    }

    public String getRuleListShare() {
        return ruleListShare;
    }

    public void setRuleListShare(String ruleListShare) {
        this.ruleListShare = ruleListShare;
    }

    public String getRuleListDownList() {
        return ruleListDownList;
    }

    public void setRuleListDownList(String ruleListDownList) {
        this.ruleListDownList = ruleListDownList;
    }

    public String getRuleList() {
        return ruleList;
    }

    public void setRuleList(String ruleList) {
        this.ruleList = ruleList;
    }

    public String getRuleListTitle() {
        return ruleListTitle;
    }

    public void setRuleListTitle(String ruleListTitle) {
        this.ruleListTitle = ruleListTitle;
    }

    public String getRuleListLink() {
        return ruleListLink;
    }

    public void setRuleListLink(String ruleListLink) {
        this.ruleListLink = ruleListLink;
    }

    public List<String> getNewNameJson() {
        return newNameJson;
    }

    public void setNewNameJson(List<String> newNameJson) {
        this.newNameJson = newNameJson;
    }

    public List<String> getNewLinkJson() {
        return newLinkJson;
    }

    public void setNewLinkJson(List<String> newLinkJson) {
        this.newLinkJson = newLinkJson;
    }

    public List<String> getNewBlockName() {
        return newBlockName;
    }

    public void setNewBlockName(List<String> newBlockName) {
        this.newBlockName = newBlockName;
    }

    public String toJsonString() {
        JSONObject jsonObject = new JSONObject();
        putJSONObject(jsonObject, "name", name);
        putJSONObject(jsonObject, "version", version);
        putJSONObject(jsonObject, "baseUrl", baseUrl);
        putJSONObject(jsonObject, "searchUrl", searchUrl);
        putJSONObject(jsonObject, "requestCharset", requestCharset);
        putJSONObject(jsonObject, "resultCharset", resultCharset);
        putJSONObject(jsonObject, "userAgent", userAgent);
        putJSONObject(jsonObject, "resultLinkHeader", resultLinkHeader);
        putJSONObject(jsonObject, "ruleResultList", ruleResultList);
        putJSONObject(jsonObject, "ruleResultTitle", ruleResultTitle);
        putJSONObject(jsonObject, "ruleResultLink", ruleResultLink);
        putJSONObject(jsonObject, "ruleResultExtra1", ruleResultExtra1);
        putJSONObject(jsonObject, "ruleResultExtra2", ruleResultExtra2);
        putJSONObject(jsonObject, "ruleResultExtra3", ruleResultExtra3);
        putJSONObject(jsonObject, "ruleResultExtra4", ruleResultExtra4);
        putJSONObject(jsonObject, "ruleDetailCoverHeader", ruleDetailCoverHeader);
        putJSONObject(jsonObject, "ruleDetailCover", ruleDetailCover);
        putJSONObject(jsonObject, "ruleDetailDesc", ruleDetailDesc);
        putJSONObject(jsonObject, "ruleListM3U8", ruleListM3U8);
        putJSONObject(jsonObject, "ruleListShare", ruleListShare);
        putJSONObject(jsonObject, "ruleListDownList", ruleListDownList);
        putJSONObject(jsonObject, "ruleList", ruleList);
        putJSONObject(jsonObject, "ruleListTitle", ruleListTitle);
        putJSONObject(jsonObject, "ruleListLink", ruleListLink);
        putJSONObject(jsonObject, "newNameJson", new JSONArray(newLinkJson));
        putJSONObject(jsonObject, "newLinkJson", new JSONArray(newLinkJson));
        putJSONObject(jsonObject, "newBlockName", new JSONArray(newBlockName));
        return jsonObject.toString();
    }

    private void putJSONObject(JSONObject jsonObject, String key, Object value) {
        if (value != null && !value.equals("")) {
            try {
                jsonObject.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public String toGsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public BaseVodRegexEntity() {
    }

    public BaseVodRegexEntity(String linker) {
        linker = linker.replace("linker://", "");
        linker = new String(Base64.decode(linker.getBytes(), Base64.DEFAULT));
        try {
            JSONObject jsonObject = new JSONObject(linker);
            name = getString(jsonObject, "name");
            version = getString(jsonObject, "version");
            baseUrl = getString(jsonObject, "baseUrl");
            searchUrl = getString(jsonObject, "searchUrl");
            requestCharset = getString(jsonObject, "requestCharset");
            resultCharset = getString(jsonObject, "resultCharset");
            userAgent = getString(jsonObject, "userAgent");
            resultLinkHeader = getString(jsonObject, "resultLinkHeader");
            ruleResultList = getString(jsonObject, "ruleResultList");
            ruleResultTitle = getString(jsonObject, "ruleResultTitle");
            ruleResultLink = getString(jsonObject, "ruleResultLink");
            ruleResultExtra1 = getString(jsonObject, "ruleResultExtra1");
            ruleResultExtra2 = getString(jsonObject, "ruleResultExtra2");
            ruleResultExtra3 = getString(jsonObject, "ruleResultExtra3");
            ruleResultExtra4 = getString(jsonObject, "ruleResultExtra4");
            ruleDetailCoverHeader = getString(jsonObject, "ruleDetailCoverHeader");
            ruleDetailCover = getString(jsonObject, "ruleDetailCover");
            ruleDetailDesc = getString(jsonObject, "ruleDetailDesc");
            ruleListM3U8 = getString(jsonObject, "ruleListM3U8");
            ruleListShare = getString(jsonObject, "ruleListShare");
            ruleListDownList = getString(jsonObject, "ruleListDownList");
            ruleList = getString(jsonObject, "ruleList");
            ruleListTitle = getString(jsonObject, "ruleListTitle");
            ruleListLink = getString(jsonObject, "ruleListLink");
            newNameJson = jsonArrayToList(getJSONArray(jsonObject, "newNameJson"));
            newLinkJson = jsonArrayToList(getJSONArray(jsonObject, "newLinkJson"));
            newBlockName = jsonArrayToList(getJSONArray(jsonObject, "newBlockName"));
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

    private JSONArray getJSONArray(JSONObject jsonObject, String key) {
        if (jsonObject.has(key)) {
            try {
                return jsonObject.getJSONArray(key);
            } catch (JSONException e) {
                return new JSONArray();
            }
        } else {
            return new JSONArray();
        }
    }

    private List<String> jsonArrayToList(JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String toBase64Linker() {
        String key = Base64.encodeToString(toJsonString().getBytes(), Base64.DEFAULT);
        return "linker://" + key;
    }
}
