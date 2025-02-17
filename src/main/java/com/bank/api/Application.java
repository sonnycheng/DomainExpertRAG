package com.bank.api;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
// @EnableRedisHttpSession
@ComponentScan(basePackages = {"com.bank.api.config","com.bank.controller","com.bank.service","com.bank.pojo","com.bank.comp"})
@MapperScan(basePackages = {"com.bank.dao"})
// @Import({RedisSessionConfig.class})
@ServletComponentScan(basePackages = "com.bank.filter")
// @EnableWebMvc
@EnableScheduling
public class Application  {
	
	
    public static void main(String[] args) {   
    	 	  		
    	new SpringApplication(Application.class).run(args);
    	 
    }
}
