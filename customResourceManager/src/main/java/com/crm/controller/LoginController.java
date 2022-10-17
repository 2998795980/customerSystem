package com.crm.controller;

import com.crm.common.ApiResult;
import com.crm.common.ApiResultCode;
import com.crm.dao.entity.Account;
import com.crm.service.LoginService;
import com.crm.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @PostMapping("login")
    public ApiResult<Object> login(String code, HttpSession session,Account login) {
        // 判断是否符合标准 验证码 账号 密码
        ApiResult<Object> standard = isStandard(code, session, login);
        HashMap<String, Object> data;

        if (standard != null) {
            return standard;
        }
        Account result = loginService.login(login);
        if(result == null) {
            return ApiResult.failed(ApiResultCode.USERNAME_OR_PASSWORD_ERROR);
        }


        switch (result.getState()) {
            // 账号密码正确
            case 1:
                // 添加 payload
                data = new HashMap<>();
                data.put("account",result.getAccount());
                data.put("username",result.getUsername());
                String token = JWTUtils.createToken(data);
                // 添加到redis
                redisTemplate.opsForValue().set("token"+token,token);
                return ApiResult.success(token);
            // 账号被禁用
            case 0: return ApiResult.failed(ApiResultCode.USER_ACCOUNT_LOCKED);
            // 账号被删除
            case -1: return ApiResult.failed(ApiResultCode.USER_NOT_EXIST);
        }
        return ApiResult.failed("登入失败，请重试");
    }

    public ApiResult<Object> isStandard(String code, HttpSession session, Account account) {
        // 判断验证码
        if (!session.getAttribute("code").equals(code.toLowerCase())) {
            return ApiResult.failed("验证码错误");
        }
        session.removeAttribute("code");

        // 判断 账号 密码 邮箱 是否符合
        if (!loginService.isStandard(account)) {
            return ApiResult.failed("账号密码不符合");
        }
        return null;
    }
}
