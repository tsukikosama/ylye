package com.example.ylye.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "spring")
public class RedisHost {

    public static  String host;
    @Value("${spring.redis.host}")
    public void setHost(String host){
        RedisHost.host = host;
    }

}
