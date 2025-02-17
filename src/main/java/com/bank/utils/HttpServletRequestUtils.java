package com.bank.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

public class HttpServletRequestUtils {

    /**
     * 解析HttpServletRequest参数
     *
     * param request
     * return
     * throws IOException
     */
    public static Map<String, Object> getRequestParams(HttpServletRequest request) throws IOException {
        String method = request.getMethod();
        if ("GET".equals(method)) {
            return getHttpServletRequestFormParams(request);
        }
        if ("POST".equals(method)) {
            return getHttpServletRequestJsonParams(request);
        }
        return new HashMap<>();
    }

    /**
     * param request
     * return java.util.Map<java.lang.String, java.lang.Object>
     * description: 获取 HttpServletRequest 参数  表单参数
     * GET:地址栏中直接给出参数
     * POST:表单
     * &#64;date: 2021/9/24
     */
    public static Map<String, Object> getHttpServletRequestFormParams(HttpServletRequest request) {
        Map<String, Object> paramMap = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(paramName);
            if (1 == parameterValues.length) {
                String paramValue = parameterValues[0];
                paramMap.put(paramName, paramValue);
            }
        }

        return paramMap;
    }

    /**
     * &#64;param request
     * &#64;return java.util.Map<java.lang.String, java.lang.Object>
     * &#64;description: 解析HttpServletRequest参数  json格式
     * POST:JSON格式
     * &#64;date: 2021/9/24
     */
    public static Map<String, Object> getHttpServletRequestJsonParams(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength <= 0) {
            return new HashMap<>();
        }
        byte[] buffer = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {
            int readLen = request.getInputStream().read(buffer, i, contentLength - i);
            if (-1 == readLen) {
                break;
            }
            i += readLen;
        }
        Map<String, Object> maps = (Map<String, Object>) JSON.parse(buffer);
        return maps;
    }
}