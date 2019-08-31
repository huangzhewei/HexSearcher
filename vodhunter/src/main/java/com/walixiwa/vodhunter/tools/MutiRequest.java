package com.walixiwa.vodhunter.tools;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * 多线程网络请求队列
 */
public class MutiRequest {
    private String url;
    private String userAgent;
    private String charset;
    private Long timeOut = 10L;
    private OnRequestFinishListener onRequestFinishListener;


    public MutiRequest setUrl(String url) {
        this.url = url;
        Log.e("info", "setUrl: " + url);
        return this;
    }

    public MutiRequest setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public MutiRequest setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public MutiRequest setCallBack(OnRequestFinishListener onRequestFinishListener) {
        this.onRequestFinishListener = onRequestFinishListener;
        return this;
    }

    public MutiRequest setTimeOut(long timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public void start() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        Request.Builder builder = new Request.Builder();
        if (!TextUtils.isEmpty(userAgent)) {
            builder.removeHeader("User-Agent").addHeader("User-Agent", userAgent);
        }
        builder.url(url);
        okHttpClient.connectTimeout(timeOut, TimeUnit.SECONDS);
        okHttpClient.readTimeout(timeOut, TimeUnit.SECONDS);
        Call call = okHttpClient.build().newCall(builder.build());

        //1.异步请求，通过接口回调告知用户 http 的异步执行结果
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (onRequestFinishListener != null) {
                    onRequestFinishListener.onRequestFinish(false, "");
                }
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    if (responseBody != null) {
                        byte[] bytes = responseBody.bytes();
                        String result = new String(bytes, TextUtils.isEmpty(charset) ? "utf-8" : charset);
                        if (onRequestFinishListener != null) {
                            onRequestFinishListener.onRequestFinish(false, result);
                        }
                    }
                } else {
                    if (onRequestFinishListener != null) {
                        onRequestFinishListener.onRequestFinish(false, "");
                    }
                }
            }
        });
    }

    public interface OnRequestFinishListener {
        void onRequestFinish(boolean status, String response);
    }
}
