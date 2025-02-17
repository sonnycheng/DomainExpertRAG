package com.bank.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bank.api.config.ConfigUtils;

// @ApiIgnore
@Controller
@RequestMapping(value="/chat")
@EnableAsync
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@Autowired
	private ConfigUtils configUtils;
	
	@Resource
	private RestTemplate restTemplate;
	

	@RequestMapping(value="/consult",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView consult(Model model,HttpServletRequest request) {
		
		    String id = request.getParameter("id");
		    logger.info("run into controller consult, id:"+id);	
		    
	        ModelAndView mav = new ModelAndView();
		    mav.addObject("clientId", 14);
		    mav.setViewName("digitalStaff");
	        return mav;
	}
	  
	
		  
	 
		  
		  
	 

 
	   
	    
	    
	    
	    
	   
}