package com.wd7.sso.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;


@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        new RedisCacheConfiguration();
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate); //设置缓存过期时间
//         rcm.setDefaultExpiration(60);//秒
//         return new RedisCacheManager(redisTemplate);
//    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory)
    {
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        //修改序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om=new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }

}
