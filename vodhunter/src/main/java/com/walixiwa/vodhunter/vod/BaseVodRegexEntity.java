package com.walixiwa.vodhunter.vod;

import android.util.Base64;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
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
        try {
            jsonObject.put("name", name);
            jsonObject.put("version", version);
            jsonObject.put("baseUrl", baseUrl);
            jsonObject.put("searchUrl", searchUrl);
            jsonObject.put("requestCharset", requestCharset);
            jsonObject.put("resultCharset", resultCharset);
            jsonObject.put("userAgent", userAgent);
            jsonObject.put("resultLinkHeader", resultLinkHeader);
            jsonObject.put("ruleResultList", ruleResultList);
            jsonObject.put("ruleResultTitle", ruleResultTitle);
            jsonObject.put("ruleResultLink", ruleResultLink);
            jsonObject.put("ruleResultExtra1", ruleResultExtra1);
            jsonObject.put("ruleResultExtra2", ruleResultExtra2);
            jsonObject.put("ruleResultExtra3", ruleResultExtra3);
            jsonObject.put("ruleResultExtra4", ruleResultExtra4);
            jsonObject.put("ruleDetailCover", ruleDetailCover);
            jsonObject.put("ruleDetailDesc", ruleDetailDesc);
            jsonObject.put("ruleListM3U8", ruleListM3U8);
            jsonObject.put("ruleListShare", ruleListShare);
            jsonObject.put("ruleListDownList", ruleListDownList);
            jsonObject.put("ruleList", ruleList);
            jsonObject.put("ruleListTitle", ruleListTitle);
            jsonObject.put("ruleListLink", ruleListLink);
            jsonObject.put("newNameJson", new JSONArray(newLinkJson));
            jsonObject.put("newLinkJson", new JSONArray(newLinkJson));
            jsonObject.put("newBlockName", new JSONArray(newBlockName));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
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
            name = jsonObject.getString("name");
            version = jsonObject.getString("version");
            baseUrl = jsonObject.getString("baseUrl");
            searchUrl = jsonObject.getString("searchUrl");
            requestCharset = jsonObject.getString("requestCharset");
            resultCharset = jsonObject.getString("resultCharset");
            userAgent = jsonObject.getString("userAgent");
            resultLinkHeader = jsonObject.getString("resultLinkHeader");
            ruleResultList = jsonObject.getString("ruleResultList");
            ruleResultTitle = jsonObject.getString("ruleResultTitle");
            ruleResultLink = jsonObject.getString("ruleResultLink");
            ruleResultExtra1 = jsonObject.getString("ruleResultExtra1");
            ruleResultExtra2 = jsonObject.getString("ruleResultExtra2");
            ruleResultExtra3 = jsonObject.getString("ruleResultExtra3");
            ruleResultExtra4 = jsonObject.getString("ruleResultExtra4");
            ruleDetailCover = jsonObject.getString("ruleDetailCover");
            ruleDetailDesc = jsonObject.getString("ruleDetailDesc");
            ruleListM3U8 = jsonObject.getString("ruleListM3U8");
            ruleListShare = jsonObject.getString("ruleListShare");
            ruleListDownList = jsonObject.getString("ruleListDownList");
            ruleList = jsonObject.getString("ruleList");
            ruleListTitle = jsonObject.getString("ruleListTitle");
            ruleListLink = jsonObject.getString("ruleListLink");
            newNameJson = jsonArrayToList(jsonObject.getJSONArray("newNameJson"));
            newLinkJson = jsonArrayToList(jsonObject.getJSONArray("newLinkJson"));
            newBlockName = jsonArrayToList(jsonObject.getJSONArray("newBlockName"));
        } catch (JSONException e) {
            e.printStackTrace();
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
