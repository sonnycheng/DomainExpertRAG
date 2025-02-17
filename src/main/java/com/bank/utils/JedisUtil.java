package com.bank.utils;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	
    private static JedisPool jedisPool = null;
    
    static  {
        //使用ResourceBundle类读取配置文件
        // ResourceBundle resourceBundle = ResourceBundle.getBundle("jedis");
        //拿到数据信息
        // String host = resourceBundle.getString("jedis.host");
        int port = Integer.parseInt("6379");
        //int maxTotal = Integer.parseInt(resourceBundle.getString("jedis.maxTotal"));
        //int maxIdle = Integer.parseInt(resourceBundle.getString("jedis.maxIdle"));
        //设置配置信息
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //jedisPoolConfig.setMaxIdle(maxIdle);
        // jedisPoolConfig.setMaxTotal(maxTotal);
        //初始化
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", port);
    }
    
    //获取redis操作对象
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
    
    public static void main(String[] args) {
    	Jedis jedis = JedisUtil.getJedis();    	
    	long dbsize = jedis.dbSize();
    	
    	System.out.println("jedis:"+jedis.hashCode());
    	System.out.println("dbsize:"+dbsize);
    }	
   
}
