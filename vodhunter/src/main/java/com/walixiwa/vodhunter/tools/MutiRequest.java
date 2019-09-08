package com.walixiwa.vodhunter.tools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

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
    private long timeOut = 10L;
    private OnRequestFinishListener onRequestFinishListener;

    private String result = "";

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (onRequestFinishListener != null) {
                    onRequestFinishListener.onRequestFinish(true, result);
                }
            } else {
                if (onRequestFinishListener != null) {
                    onRequestFinishListener.onRequestFinish(false, result);
                }
            }
        }
    };

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
        okHttpClient.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;//关闭ssl校验
            }
        });
        Call call = okHttpClient.build().newCall(builder.build());

        //1.异步请求，通过接口回调告知用户 http 的异步执行结果
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                result = e.toString();
                handler.sendEmptyMessage(0);
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) {
                if (response.isSuccessful()) {
                    try {
                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            byte[] bytes = responseBody.bytes();
                            result = new String(bytes, TextUtils.isEmpty(charset) ? "utf-8" : charset);
                            handler.sendEmptyMessage(1);
                        } else {
                            Log.e("okHttp", "onResponse: null");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        result = e.toString();
                        handler.sendEmptyMessage(0);
                    }
                } else {
                    Log.e("okHttp", "onResponse: " + response.message());
                    result = "";
                    handler.sendEmptyMessage(0);
                }
            }
        });
    }

    public interface OnRequestFinishListener {
        void onRequestFinish(boolean status, String response);
    }
}
