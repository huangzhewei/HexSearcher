package com.walixiwa.vodhunter.tools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.walixiwa.vodhunter.thunder.BaseMagRegxEntity;
import com.walixiwa.vodhunter.thunder.BaseMagItemEntity;

import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MagSearcher {
    private BaseMagRegxEntity magRegxEntity;
    private List<BaseMagItemEntity> vodItemEntityList = new ArrayList<>();
    private String keyWords;
    private int page;
    private List<String> blockWords = new ArrayList<>();
    private OnRequestFinishListener onRequestFinishListener;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NotNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (null != onRequestFinishListener) {
                    onRequestFinishListener.onRequestFinish(vodItemEntityList);
                }
            }
        }
    };

    public MagSearcher init(BaseMagRegxEntity magRegxEntity) {
        this.magRegxEntity = magRegxEntity;
        return this;
    }

    public MagSearcher with(String keyWords, int page) {
        this.keyWords = keyWords;
        this.page = page;
        return this;
    }


    public MagSearcher setBlockWords(List<String> blockWords) {
        this.blockWords.addAll(blockWords);
        return this;
    }

    public MagSearcher setCallBack(OnRequestFinishListener onRequestFinishListener) {
        this.onRequestFinishListener = onRequestFinishListener;
        return this;
    }

    public void start() {
        String searchKey = TextUtils.isEmpty(magRegxEntity.getRequestCharset()) ? urlEncode(keyWords, "utf-8") : urlEncode(keyWords, magRegxEntity.getRequestCharset());
        String url = magRegxEntity.getSearchUrl().replace("%keyWords", searchKey).replace("%page", Integer.toString(page));
        new MutiRequest()
                .setUrl(url)
                .setCharset(magRegxEntity.getResultCharset())
                .setUserAgent(magRegxEntity.getUserAgent())
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
            Pattern pattern = Pattern.compile(magRegxEntity.getRuleResultList(), Pattern.CASE_INSENSITIVE);//匹配整条链接
            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                String resultList = matcher.group(); //匹配整条链接结果
                boolean isBlock = false;
                for (int i = 0; i < blockWords.size(); i++) {
                    if (resultList.contains(blockWords.get(i))) {
                        isBlock = true;
                        break;
                    }
                }
                if (!isBlock) {
                    String resultLinkHeader = magRegxEntity.getResultLinkHeader();
                    String resultLink;
                    if (TextUtils.isEmpty(resultLinkHeader)) {
                        resultLink = matchString(resultList, magRegxEntity.getRuleResultLink());
                    } else {
                        resultLink = resultLinkHeader + matchString(resultList, magRegxEntity.getRuleResultLink());
                    }
                    String resultTitle = matchString(resultList, magRegxEntity.getRuleResultTitle());
                    for (int i = 0; i < magRegxEntity.getReplaceWords().size(); i++) {
                        resultTitle = resultTitle.replaceAll(magRegxEntity.getReplaceWords().get(i), "");
                    }
                    String extra1 = TextUtils.isEmpty(magRegxEntity.getRuleResultExtra1()) ? "" : matchString(resultList, magRegxEntity.getRuleResultExtra1());
                    String extra2 = TextUtils.isEmpty(magRegxEntity.getRuleResultExtra2()) ? "" : matchString(resultList, magRegxEntity.getRuleResultExtra2());
                    String extra3 = TextUtils.isEmpty(magRegxEntity.getRuleResultExtra3()) ? "" : matchString(resultList, magRegxEntity.getRuleResultExtra3());
                    String extra4 = TextUtils.isEmpty(magRegxEntity.getRuleResultExtra4()) ? "" : matchString(resultList, magRegxEntity.getRuleResultExtra4());
                    BaseMagItemEntity vodItemEntity = new BaseMagItemEntity();
                    vodItemEntity.setResultTitle(resultTitle);
                    vodItemEntity.setResultLink(resultLink);
                    vodItemEntity.setResultExtra1(extra1);
                    vodItemEntity.setResultExtra2(extra2);
                    vodItemEntity.setResultExtra3(extra3);
                    vodItemEntity.setResultExtra4(extra4);
                    vodItemEntity.setBaseMagRegxEntity(magRegxEntity);
                    if (!vodItemEntityList.contains(vodItemEntity)) {
                        vodItemEntityList.add(vodItemEntity);
                    }
                }
            }
        }
        handler.sendEmptyMessage(1);
    }

    public interface OnRequestFinishListener {
        void onRequestFinish(List<BaseMagItemEntity> baseVodItemEntities);
    }

    /**
     * 根据单个正则规则，默认返回第一个匹配项
     *
     * @param value
     * @param regex
     * @return
     */
    private String matchString(String value, String regex) {
        String result = "";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return NativeDecoder.decode(result == null ? "" : result.replaceAll("<.*?>", "").replaceAll("\\s", "").trim());
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
