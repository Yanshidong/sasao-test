package com.wd7.sso.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MyAuthorizationCodeServices  extends RandomValueAuthorizationCodeServices{


    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Value("${oauth2.code.timeout}")
    private Integer timeout;

    @Value("${oauth2.code.prefix")
    private String prefix;

    @Override
    protected void store(String code, OAuth2Authentication authentication) {

        //存储一个code
        redisTemplate.opsForValue().set(prefix+code,authentication,timeout, TimeUnit.SECONDS);



    }

    @Override
    protected OAuth2Authentication remove(String code) {
        //消费一个code
        OAuth2Authentication oAuth2Authentication= (OAuth2Authentication) redisTemplate.opsForValue().get(code);

        if(oAuth2Authentication==null)
        {
            return null;
        }
        redisTemplate.delete(code);
        return oAuth2Authentication;
    }
}
