package com.walixiwa.vodhunter.tools;

import android.text.TextUtils;
import android.util.Log;

import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.tools.HeaderUtils;
import com.yanzhenjie.nohttp.tools.IOUtils;

public class MyCharestRequest extends Request<String> {

    private static String myCharset = "utf-8";

    public MyCharestRequest(String url) {
        this(url, RequestMethod.GET);
    }

    public MyCharestRequest(String url, String charset) {
        this(url, RequestMethod.GET);
        if (!TextUtils.isEmpty(charset)) {
            myCharset = charset;
        }
    }

    public MyCharestRequest(String url, RequestMethod requestMethod) {
        super(url, requestMethod);
    }

    @Override
    public String parseResponse(Headers responseHeaders, byte[] responseBody) throws Exception {
        return parseResponseString(responseHeaders, responseBody);
    }

    /**
     * Parse http response to string.
     */
    public static String parseResponseString(Headers responseHeaders, byte[] responseBody) {
        if (responseBody == null || responseBody.length == 0){
            return "";
        }
        Log.e("myCharset", "parseResponseString: " + myCharset);
        return IOUtils.toString(responseBody, myCharset);
    }
}
