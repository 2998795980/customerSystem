package com.crm.test;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import com.crm.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.HashMap;

@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void jwtTest() {
        HashMap<String, Object> string = new HashMap<>();
        string.put("abc","hello");

        String s = JWTUtils.createToken(string);

        System.out.println(s);
        System.out.println(JWTUtils.verifyToken(s));

        System.out.println(JWTUtils.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50Ijoicm9vdCIsInVzZXJuYW1lIjoiRm9vbCJ9.YgzQLNTKPeFiGDveONe3gQV-DXdZt3U9aZ__rsEJ095"));

    }

    @Test
    public void redis() {
        redisTemplate.opsForValue().set("aaa","bbb");


    }
}
