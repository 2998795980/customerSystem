package com.crm.controller;

import com.crm.common.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @GetMapping("logout")
    public ApiResult<String> logout() {
        // 获取token
        String token = "";

        redisTemplate.delete("token"+token);
        return ApiResult.success();
    }
}
