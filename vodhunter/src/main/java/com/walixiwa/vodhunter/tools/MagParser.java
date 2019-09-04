package com.walixiwa.vodhunter.tools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

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
    private List<String> links = new ArrayList<>();
    private String link;
    private OnParseFinishListener onParseFinishListener;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NotNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (null != onParseFinishListener) {
                    onParseFinishListener.onParseFinish(links);
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
        if (!TextUtils.isEmpty(html)) {
            Pattern pattern = Pattern.compile(vodRegexEntity.getRuleDetailLink());
            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                String result = TextUtils.isEmpty(vodRegexEntity.getRuleDetailLinkHeader()) ? matcher.group() : vodRegexEntity.getRuleDetailLinkHeader() + matcher.group();
                if (!links.contains(result)) {
                    links.add(result);
                }
            }
        }
        handler.sendEmptyMessage(1);
    }

    public interface OnParseFinishListener {
        void onParseFinish(List<String> links);
    }

}
