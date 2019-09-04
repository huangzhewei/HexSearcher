package com.walixiwa.vodhunter.thunder;

import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BaseMagRegxEntity {
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

    private boolean isSecondPage = false;

    private String ruleDetailLinkHeader = "";
    private String ruleDetailLink = "";

    private List<String> replaceWords = new ArrayList<>();

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

    public boolean isSecondPage() {
        return isSecondPage;
    }

    public void setSecondPage(boolean secondPage) {
        isSecondPage = secondPage;
    }

    public String getRuleDetailLink() {
        return ruleDetailLink;
    }

    public void setRuleDetailLink(String ruleDetailLink) {
        this.ruleDetailLink = ruleDetailLink;
    }

    public String getRuleDetailLinkHeader() {
        return ruleDetailLinkHeader;
    }

    public void setRuleDetailLinkHeader(String ruleDetailLinkHeader) {
        this.ruleDetailLinkHeader = ruleDetailLinkHeader;
    }

    public List<String> getReplaceWords() {
        return replaceWords;
    }

    public void setReplaceWords(List<String> replaceWords) {
        this.replaceWords = replaceWords;
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
        putJSONObject(jsonObject, "ruleDetailLink", ruleDetailLink);
        putJSONObject(jsonObject, "ruleDetailLinkHeader", ruleDetailLinkHeader);
        putJSONObject(jsonObject, "isSecondPage", isSecondPage);
        putJSONObject(jsonObject, "replaceWords", new JSONArray(replaceWords));
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

    public BaseMagRegxEntity() {
    }

    public BaseMagRegxEntity(String linker) {
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
            if (jsonObject.has("isSecondPage")) {
                isSecondPage = jsonObject.getBoolean("isSecondPage");
            }
            ruleDetailLink = getString(jsonObject, "ruleDetailLink");
            ruleDetailLinkHeader = getString(jsonObject, "ruleDetailLinkHeader");
            replaceWords = jsonArrayToList(getJSONArray(jsonObject,"replaceWords"));
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
