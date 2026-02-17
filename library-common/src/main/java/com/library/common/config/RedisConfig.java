package com.library.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.library.common.util.RedisUtil;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> customRedisTemplate(LettuceConnectionFactory factory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //配置連線工廠
        redisTemplate.setConnectionFactory(factory);
        //設置key序列化方式string
        redisTemplate.setKeySerializer(RedisSerializer.string());
        //設置value序列化方式json
        redisTemplate.setValueSerializer(RedisSerializer.json());
        //設置hash的key的序列化方式
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        //hash value序列化json
        redisTemplate.setHashValueSerializer(RedisSerializer.json());
        //開啟事務
        redisTemplate.setEnableTransactionSupport(true);
        //使配置生效
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean(name = "redisUtil")
    public RedisUtil redisUtil(RedisTemplate<String, Object> redisTemplate){
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setRedisTemplate(redisTemplate);
        return redisUtil;
    }
}
