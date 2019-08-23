package com.walixiwa.vodhunter.tools;

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

    public MyCharestRequest(String url, RequestMethod requestMethod) {
        super(url, requestMethod);
    }

    @Override
    public String parseResponse(Headers responseHeaders, byte[] responseBody) throws Exception {
        return parseResponseString(responseHeaders, responseBody);
    }

    /**
     * Parse http response to string.
     *
     * @param responseHeaders header from http response.
     * @param responseBody    byteArray from http response.
     * @return result fro response.
     */
    public static String parseResponseString(Headers responseHeaders, byte[] responseBody) {
        if (responseBody == null || responseBody.length == 0)
            return "";
        String charset = HeaderUtils.parseHeadValue(responseHeaders.getContentType(), "charset", myCharset);
        return IOUtils.toString(responseBody, charset);
    }

    public void setCharset(String charset) {
        myCharset = charset;
    }
}
