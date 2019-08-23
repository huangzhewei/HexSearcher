package com.walixiwa.vodhunter.tools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.walixiwa.vodhunter.vod.BaseVodDetailEntity;
import com.walixiwa.vodhunter.vod.BaseVodPlayEntity;
import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;

import java.net.Proxy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VodParser {
    private BaseVodRegexEntity vodRegexEntity;
    private BaseVodDetailEntity baseVodDetailEntity = new BaseVodDetailEntity();
    private String link;
    private OnParseFinishListener onParseFinishListener;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (null != onParseFinishListener) {
                    onParseFinishListener.onParseFinish(baseVodDetailEntity);
                }
            }
        }
    };

    public VodParser init(BaseVodRegexEntity vodRegexEntity) {
        this.vodRegexEntity = vodRegexEntity;
        return this;
    }

    public VodParser with(String link) {
        this.link = link;
        return this;
    }

    public VodParser setCallBack(OnParseFinishListener onParseFinishListener) {
        this.onParseFinishListener = onParseFinishListener;
        return this;
    }

    public void start() {
        MyCharestRequest request = new MyCharestRequest(link);
        request.setCharset(TextUtils.isEmpty(vodRegexEntity.getResultCharset()) ? "utf-8" : vodRegexEntity.getResultCharset());
        request.setProxy(Proxy.NO_PROXY);
        request.setCacheMode(CacheMode.NONE_CACHE_REQUEST_NETWORK);
        if (!TextUtils.isEmpty(vodRegexEntity.getUserAgent())) {
            request.setUserAgent(vodRegexEntity.getUserAgent());
        }
        MutiRequest.getInstance().add(link.hashCode(), request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, final Response<String> response) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        parse(response.get());
                    }
                }).start();
            }

            @Override
            public void onFailed(int what, final Response<String> response) {
                parse("");
            }

            @Override
            public void onFinish(int what) {

            }
        });
    }

    private void parse(String html) {
        if (!TextUtils.isEmpty(html)) {
            if (!TextUtils.isEmpty(vodRegexEntity.getRuleDetailCover())) {
                baseVodDetailEntity.setCover(matchString(html, vodRegexEntity.getRuleDetailCover()));
            }
            if (!TextUtils.isEmpty(vodRegexEntity.getRuleDetailDesc())) {
                baseVodDetailEntity.setDesc(matchString(html, vodRegexEntity.getRuleDetailDesc()));
            }

            if (!TextUtils.isEmpty(vodRegexEntity.getRuleListM3U8())) {
                Pattern pattern = Pattern.compile(vodRegexEntity.getRuleListM3U8());
                Matcher matcher = pattern.matcher(html);
                while (matcher.find()) {
                    String result = matcher.group();
                    Pattern linkPattern = Pattern.compile(vodRegexEntity.getRuleList());
                    Matcher linkMatcher = linkPattern.matcher(result);
                    while (linkMatcher.find()) {
                        String find = linkMatcher.group();
                        String title = matchString(find, vodRegexEntity.getRuleListTitle());
                        String link = matchString(find, vodRegexEntity.getRuleListLink());
                        baseVodDetailEntity.getM3u8List().add(new BaseVodPlayEntity(title, link));
                    }
                }
            }

            if (!TextUtils.isEmpty(vodRegexEntity.getRuleListShare())) {
                Pattern pattern = Pattern.compile(vodRegexEntity.getRuleListShare());
                Matcher matcher = pattern.matcher(html);
                while (matcher.find()) {
                    String result = matcher.group();
                    Pattern linkPattern = Pattern.compile(vodRegexEntity.getRuleList());
                    Matcher linkMatcher = linkPattern.matcher(result);
                    while (linkMatcher.find()) {
                        String find = linkMatcher.group();
                        String title = matchString(find, vodRegexEntity.getRuleListTitle());
                        String link = matchString(find, vodRegexEntity.getRuleListLink());
                        baseVodDetailEntity.getShareList().add(new BaseVodPlayEntity(title, link));
                    }
                }
            }

            if (!TextUtils.isEmpty(vodRegexEntity.getRuleListDownList())) {
                Pattern pattern = Pattern.compile(vodRegexEntity.getRuleListDownList());
                Matcher matcher = pattern.matcher(html);
                while (matcher.find()) {
                    String result = matcher.group();
                    Pattern linkPattern = Pattern.compile(vodRegexEntity.getRuleList());
                    Matcher linkMatcher = linkPattern.matcher(result);
                    while (linkMatcher.find()) {
                        String find = linkMatcher.group();
                        String title = matchString(find, vodRegexEntity.getRuleListTitle());
                        String link = matchString(find, vodRegexEntity.getRuleListLink());
                        baseVodDetailEntity.getDownList().add(new BaseVodPlayEntity(title, link));
                    }
                }
            }
        }
        handler.sendEmptyMessage(1);
    }

    public interface OnParseFinishListener {
        void onParseFinish(BaseVodDetailEntity vodDetailEntity);
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
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result == null ? "" : result.replaceAll("<.*?>", "").trim();
    }
}
