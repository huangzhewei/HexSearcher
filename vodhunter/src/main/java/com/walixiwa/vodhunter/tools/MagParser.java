package com.walixiwa.vodhunter.tools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.walixiwa.vodhunter.thunder.BaseMagDetailEntity;
import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;
import com.walixiwa.vodhunter.vod.BaseVodDetailEntity;
import com.walixiwa.vodhunter.vod.BaseVodPlayEntity;
import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MagParser {
    private BaseMagRegxEntity vodRegexEntity;
    private List<BaseMagDetailEntity> magDetailEntities = new ArrayList<>();
    private String link;
    private OnParseFinishListener onParseFinishListener;
    private List<String> checker = new ArrayList<>();
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NotNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (null != onParseFinishListener) {
                    onParseFinishListener.onParseFinish(magDetailEntities);
                }
            }
        }
    };

    public MagParser init(BaseMagRegxEntity vodRegexEntity) {
        this.vodRegexEntity = vodRegexEntity;
        return this;
    }

    public MagParser with(String link) {
        this.link = link;
        return this;
    }

    public MagParser setCallBack(OnParseFinishListener onParseFinishListener) {
        this.onParseFinishListener = onParseFinishListener;
        return this;
    }

    public void start() {
        new MutiRequest()
                .setUrl(link)
                .setCharset(vodRegexEntity.getResultCharset())
                .setUserAgent(vodRegexEntity.getUserAgent())
                .setCallBack(new MutiRequest.OnRequestFinishListener() {
                    @Override
                    public void onRequestFinish(boolean status, String response) {
                        parse(response);
                    }
                })
                .start();
    }

    private void parse(String html) {
        //Log.e("parse", "parse: " + html);
        if (!TextUtils.isEmpty(html)) {
            Pattern pattern = Pattern.compile(vodRegexEntity.getRuleDetailList(), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                String result = matcher.group();
                BaseMagDetailEntity magDetailEntity = new BaseMagDetailEntity();
                if (!TextUtils.isEmpty(vodRegexEntity.getRuleDetailTitle())) {
                    String title = matchString(result, vodRegexEntity.getRuleDetailTitle());
                    magDetailEntity.setTitle(title);
                } else {
                    magDetailEntity.setTitle("");
                }
                if (!TextUtils.isEmpty(vodRegexEntity.getRuleDetailLink())) {
                    String link = matchString(result, vodRegexEntity.getRuleDetailLink());
                    link = TextUtils.isEmpty(vodRegexEntity.getRuleDetailLinkHeader()) ? link : vodRegexEntity.getRuleDetailLinkHeader() + link;
                    magDetailEntity.setLink(link);
                    if (!checker.contains(link)) {
                        checker.add(link);
                        magDetailEntities.add(magDetailEntity);
                    }
                }
            }
        }
        handler.sendEmptyMessage(1);
    }

    public interface OnParseFinishListener {
        void onParseFinish(List<BaseMagDetailEntity> links);
    }


    /**
     * 根据单个正则规则，默认返回第一个匹配项
     *
     * @param value
     * @param regx
     * @return
     */
    private String matchString(String value, String regx) {
        String result = "";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return NativeDecoder.decode(result == null ? "" : result.replaceAll("<.*?>", "").replaceAll("\\s", "").trim());
    }

}
