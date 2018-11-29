package com.wd7.sso;

import com.wd7.sso.config.CustomeConfigurationOAuth2Properties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    CustomeConfigurationOAuth2Properties customeConfigurationOAuth2Properties;


    @Test
    public void testRedisSet()
    {
        AUser user=new AUser(1,"er",true);

        SerializationUtils.serialize(user);
        redisTemplate.execute(new RedisCallback<Long>() {

            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set("a".getBytes(), SerializationUtils.serialize(user),
                        Expiration.from(10, TimeUnit.MINUTES), RedisStringCommands.SetOption.UPSERT);
                return 1L;
            }
        });
//       redisTemplate.exec().set("a",user);

    }

    @Test
    public void testRedisStringGet()
    {
        AUser user=  redisTemplate.execute(new RedisCallback<AUser>() {

        @Override
        public AUser doInRedis(RedisConnection connection) throws DataAccessException {
            byte[] keyByte = "a".getBytes();
            byte[] valueByte = connection.get(keyByte);

            if (valueByte != null) {
//                connection.del(keyByte);
                return (AUser) SerializationUtils.deserialize(valueByte);
            }

            return null;
        }
    });
//        System.out.println(user.toString());
        System.out.println(user == null?"0":"1");
    }

    @Test
    public void testSerializeSpeedEncodeJackson2()
    {
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(AUser.class);
        List<AUser> aUserList=this.getAUserListOriginal();

        for(AUser aUser:aUserList)
        {
            byte[] en= jackson2JsonRedisSerializer.serialize(aUser);
        }

    }

    @Test
    public void testSerializeSpeedEncodeKry()
    {

    }

    public List<AUser> getAUserListOriginal()
    {
        List<AUser> aUsers=new ArrayList<>();

        for(int i=0;i<1000000;i++)
        {
            AUser aUser=new AUser(i,"abc",true);
            aUser.setIn(i);
            aUser.setBoy(true);
            aUser.setName("abc");
            aUsers.add(aUser);
        }

        return aUsers;
    }

    @Test
    public void testCustomProperties()
    {

        Integer timeout=customeConfigurationOAuth2Properties.getCode().getTimeout();

       System.out.println(timeout);
    }


    @Test
    public void testRedisGetSerialize()
    {
        redisTemplate.opsForValue().get("oauth2:codeQHYLWw");

    }


}

