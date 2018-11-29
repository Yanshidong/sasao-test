package com.wd7.sso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;



    @Test
    public void testRedisSet()
    {
        AUser user=new AUser();
        user.setBoy(true);
        user.setIn(1);
        user.setName("er");

//        StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.afterPropertiesSet();
        redisTemplate.opsForValue().set("a", user,10, TimeUnit.SECONDS);

//       redisTemplate.exec().set("a",user);

    }

    @Test
    public void testRedisStringGet()
    {
//        StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer<Object>(Object.class);
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.afterPropertiesSet();
        redisTemplate.delete("a");
        AUser user= (AUser) redisTemplate.opsForValue().get("a");
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
            AUser aUser=new AUser();
            aUser.setIn(i);
            aUser.setBoy(true);
            aUser.setName("abc");
            aUsers.add(aUser);
        }

        return aUsers;
    }



}

