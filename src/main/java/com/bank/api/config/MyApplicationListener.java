package com.bank.api.config;

import java.net.URL;
import java.util.Properties;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyApplicationListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
		
	    if(applicationEvent.getClass().getName().contains("ApplicationStartedEvent")){
	    	System.out.println("This is my MyApplicationListener start!"+applicationEvent.getClass().getName());
	    	String path = System.getProperty("user.dir");
	    	
	    	URL   url = this.getClass().getResource("/");
	    	String path2 = url.getPath();
	    	System.out.println("path:"+path);
	    	System.out.println("path2:"+path2);
	    	
	    	/**
	    	Properties props = new Properties();	    
	    	props.put("python.home","D:/software/Python/Python310.11/Lib");	    	
	    	props.put("python.console.encoding", "UTF-8"); 
	    	props.put("python.security.respectJavaAccessibility", "false"); 
	    	props.put("python.import.site","false"); 
	    	
	    	Properties preprops = System.getProperties(); 
	    	PythonInterpreter.initialize(preprops, props, new String[0]);
	    	
	    	PythonInterpreter interpreter = new PythonInterpreter();       
	    	//interpreter.exec("from langchain_ollama import ChatOllama");
	    	
		    // interpreter.exec("result = Ollama.getresult()");
	    	interpreter.exec("import sys");
	    	// D:\\software\\Python\\Python310.11\\lib\\site-packages
	    	interpreter.exec("sys.path.append('D:/software/Python/Python310.11/lib/site-packages')");
	    	interpreter.exec("sys.path.append('D:/software/Python/Python310.11/DLLs')");
	    	// D:\\software\\Python\\Python310.11\\lib
	    	interpreter.exec("sys.path.append('D:/software/Python/Python310.11/lib')");
	    	interpreter.exec("sys.path.append('D:/software/Python/Python310.11')");
	    	interpreter.exec("sys.path.append('D:/workspace_wanda/ChatRoom/src/main/resources/python')");
	    	// interpreter.exec("from ollama import getresult");
	    	
	    	interpreter.execfile("D:/workspace_wanda/ChatRoom/src/main/resources/python/ollama.py");
		    // PyObject function = interpreter.get("getresult");
		    // PyObject result = function.__call__();
   
		    // System.out.println("ollama response:"+result.toString());
		    
		    System.out.println("path2:"+path2);
		     
		    interpreter.close();
		    **/
	    }
		//  applicationEvent.getSource().toString()
		// ApplicationStartedEvent
		// org.springframework.boot.context.event.ApplicationStartedEvent
	}

}
