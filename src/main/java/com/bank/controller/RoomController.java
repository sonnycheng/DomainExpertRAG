package com.bank.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bank.api.config.ConfigUtils;

// @ApiIgnore
@RestController
@RequestMapping(value="/room")
@ResponseBody
public class RoomController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@Autowired
	private ConfigUtils configUtils;
	
	@Resource
	private RestTemplate restTemplate;
	    
	
	@RequestMapping(value="/service",method = {RequestMethod.GET,RequestMethod.POST})
	public String service(HttpServletRequest request,@RequestBody String message) {
		
		// String message = request.getParameter("message");
		logger.info("run into controller chat client2,message:"+message);	
	
		String clientName = "client"+message;
	
		Map<String, Object> requestBody = new HashMap<>();
		 
	    requestBody.put("id", 1L);
	    requestBody.put("message", message);
	    HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(requestBody, requestHeaders);
	 
	    // String url = "http://localhost:6678/modelService";
	    // greet
	    String url = "http://localhost:6678/greet";
	    String result = restTemplate.postForObject(url, httpEntity, String.class);
	    result = result.replaceAll("\n\n", "</br>") ; 
		
	    // String result = "This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!This is response test!";
	    logger.info(result);
	  	    
	    return result;
	}
	
	@RequestMapping(value="/model2",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView model2(HttpServletRequest request,@RequestBody String message) {
		
		// String message = request.getParameter("message");
		logger.info("run into controller chat client2,message:"+message);	
	
		String clientName = "client"+message;
		
		Map<String, Object> requestBody = new HashMap<>();
		 
	    requestBody.put("id", 1L);
	    requestBody.put("message", message);
	    HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(requestBody, requestHeaders);
	 
	    String url = "http://localhost:6678/modelService";
	    String result = restTemplate.postForObject(url, httpEntity, String.class);
	    int index = result.indexOf("总结一下");
	    logger.info("result:"+result);
	    
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("clientId", message);
	    mav.addObject("clientName", clientName);
	    mav.setViewName("chat");
	    
	    return mav;
	}
	    
	    
	   
}