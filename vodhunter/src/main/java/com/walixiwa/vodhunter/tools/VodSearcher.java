package com.walixiwa.vodhunter.tools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.walixiwa.vodhunter.vod.BaseVodItemEntity;
import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VodSearcher {
    private BaseVodRegexEntity vodRegexEntity;
    private List<BaseVodItemEntity> vodItemEntityList = new ArrayList<>();
    private String keyWords;
    private int page;
    private OnRequestFinishListener onRequestFinishListener;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (null != onRequestFinishListener) {
                    onRequestFinishListener.onRequestFinish(vodItemEntityList);
                }
            }
        }
    };

    public VodSearcher init(BaseVodRegexEntity vodRegexEntity) {
        this.vodRegexEntity = vodRegexEntity;
        return this;
    }

    public VodSearcher with(String keyWords, int page) {
        this.keyWords = keyWords;
        this.page = page;
        return this;
    }

    public VodSearcher setCallBack(OnRequestFinishListener onRequestFinishListener) {
        this.onRequestFinishListener = onRequestFinishListener;
        return this;
    }

    public void start() {
        String searchKey = TextUtils.isEmpty(vodRegexEntity.getRequestCharset()) ? urlEncode(keyWords, "utf-8") : urlEncode(keyWords, vodRegexEntity.getRequestCharset());
        String url = vodRegexEntity.getSearchUrl().replace("%keyWords", searchKey).replace("%page", Integer.toString(page));
        MyCharestRequest request = new MyCharestRequest(url);
        request.setCharset(TextUtils.isEmpty(vodRegexEntity.getResultCharset()) ? "utf-8" : vodRegexEntity.getResultCharset());
        request.setProxy(Proxy.NO_PROXY);
        request.setCacheMode(CacheMode.NONE_CACHE_REQUEST_NETWORK);
        if (!TextUtils.isEmpty(vodRegexEntity.getUserAgent())) {
            request.setUserAgent(vodRegexEntity.getUserAgent());
        }
        MutiRequest.getInstance().add(url.hashCode(), request, new OnResponseListener<String>() {
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
            Pattern pattern = Pattern.compile(vodRegexEntity.getRuleResultList());//匹配整条链接
            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                String resultList = matcher.group(); //匹配整条链接结果
                List<String> blockList = vodRegexEntity.getNewBlockName();//过滤排除掉的分类
                boolean blocked = false;
                if (blockList != null) {
                    for (String name : blockList) {
                        if (resultList.contains(name)) {
                            blocked = true;
                        }
                    }
                }
                if (!blocked) {
                    String resultLinkHeader = vodRegexEntity.getResultLinkHeader();
                    String resultLink;
                    if (TextUtils.isEmpty(resultLinkHeader)) {
                        resultLink = matchString(resultList, vodRegexEntity.getRuleResultLink());
                    } else {
                        resultLink = resultLinkHeader + matchString(resultList, vodRegexEntity.getRuleResultLink());
                    }
                    String resultTitle = matchString(resultList, vodRegexEntity.getRuleResultTitle());
                    String extra1 = TextUtils.isEmpty(vodRegexEntity.getRuleResultExtra1()) ? "" : matchString(resultList, vodRegexEntity.getRuleResultExtra1());
                    String extra2 = TextUtils.isEmpty(vodRegexEntity.getRuleResultExtra2()) ? "" : matchString(resultList, vodRegexEntity.getRuleResultExtra2());
                    String extra3 = TextUtils.isEmpty(vodRegexEntity.getRuleResultExtra3()) ? "" : matchString(resultList, vodRegexEntity.getRuleResultExtra3());
                    String extra4 = TextUtils.isEmpty(vodRegexEntity.getRuleResultExtra4()) ? "" : matchString(resultList, vodRegexEntity.getRuleResultExtra4());
                    BaseVodItemEntity vodItemEntity = new BaseVodItemEntity();
                    vodItemEntity.setResultTitle(resultTitle);
                    vodItemEntity.setResultLink(resultLink);
                    vodItemEntity.setResultExtra1(extra1);
                    vodItemEntity.setResultExtra2(extra2);
                    vodItemEntity.setResultExtra3(extra3);
                    vodItemEntity.setResultExtra4(extra4);
                    vodItemEntity.setBaseVodRegexEntity(vodRegexEntity);
                    vodItemEntityList.add(vodItemEntity);
                }
            }
        }
        handler.sendEmptyMessage(1);
    }

    public interface OnRequestFinishListener {
        void onRequestFinish(List<BaseVodItemEntity> baseVodItemEntities);
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

    /**
     * url文本编码，解决空格编码异常问题
     *
     * @param str
     * @return
     */
    private static String urlEncode(String str, String enc) {
        String wd = null;
        try {
            wd = URLEncoder.encode(str, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return wd == null ? str : wd.replace("+", "%20");
    }
}
