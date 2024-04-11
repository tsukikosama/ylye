package com.example.ylye.config;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.beans.ConstructorProperties;
import java.io.InputStream;
import java.util.Properties;

//@Component
//@Configuration
//@AutoConfigureAfter(RedisHost.class)
public class RedisConnectFactory {
    private static final JedisPool jedisPool;
    //@value不能用在静态代码和final里
//    @Value("${spring.redis.host)")
//    private static ApplicationContext context;
    @Value("${spring.redis.host}")
    public String url;

    static {

        //构建jedis配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        //设置最大连接数
        jedisPoolConfig.setMaxTotal(8);
        //最大空闲数
        jedisPoolConfig.setMaxIdle(8);
        //最小空闲数
        jedisPoolConfig.setMinIdle(0);
        //设置等待时间  1000秒还没有线程就报错
        jedisPoolConfig.setMaxWaitMillis(1000);
//        RedisHost host = new RedisHost();
//        url = RedisHost.host;
        System.out.println(RedisHost.host);
        //在static中读取配置文件
//        Properties prop = new Properties();
//        InputStream in = Object.class.getResourceAsStream("/application.yml");
//        try {
//            prop.load(in);
//            url =  prop.getProperty("host");
//            System.out.println(url + "ssssss");
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379,1000,"");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}