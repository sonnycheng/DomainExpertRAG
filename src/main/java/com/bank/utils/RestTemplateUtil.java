package com.bank.utils;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
 
/**
 * RestTemplate请求工具类
 *
 * @author Eric
 * @date 2023-08-03 10:36
 */
@Slf4j
public class RestTemplateUtil {
 
    /**
     * post请求
     *
     * @param url       请求路径
     * @param parameter 请求参数
     * @return 返回值
     */
    public static String post(String url, Map<String, Object> parameter) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> r = new HttpEntity<Map<String, Object>>(parameter, requestHeaders);
        String body = restTemplate.postForObject(url, r, String.class);
//        log.info("远程调用结果，body为：{}", body);
        return body;
    }
 
    /**
     * get请求
     *
     * @param url       请求路径
     * @param parameter 请求参数
     * @return 返回值
     */
    public static String get(String url, Map<String, Object> parameter) {
        if (!parameter.isEmpty()) {
            url = url + "?";
            for (String key : parameter.keySet()) {
                url = url + key + "=" + parameter.get(key) + "&";
            }
            url = url.substring(0, url.length() - 1);
        }
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String body = restTemplate.getForEntity(url, String.class, parameter).getBody();
//        log.info("远程调用结果，body为：{}", body);
        return body;
    }
 
}

