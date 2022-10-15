package com.crm.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.common.ApiResult;
import com.crm.dao.entity.Account;
import com.crm.service.RegisterService;
import com.crm.utils.CaptchaGenerate;

import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;
    @Autowired
    CaptchaGenerate captchaGenerate;

    /**
     * 获取验证码
     * 
     * @param session session对象
     * @param response response对象
     */
    @GetMapping("captcha")
    public void captcha(HttpSession session, HttpServletResponse response) {
        // 创建hutool-captcha对象
        ICaptcha iCaptcha = captchaGenerate.RandomSelectMethod();
        // 获取code验证码
        String code = iCaptcha.getCode();
        // 存入session域中
        session.setAttribute("code", code.toLowerCase());
        // 输出验证码图片
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            iCaptcha.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 注册账号
     * 
     * @param code 验证码
     * @param session session对象
     * @param register Account对象
     * @return 结果
     */
    @PostMapping("register")
    public ApiResult<Void> register(String code, HttpSession session, Account register) {
        // 判断是否符合标准 验证码 账号 密码
        ApiResult<Void> standard = isStandard(code, session, register);
        if (standard != null) {
            return standard;
        }
        // 注册
        register.setCreatedTime(LocalDateTimeUtil.now());
        register.setState(1);
        registerService.insertAccount(register);
        return ApiResult.success();
    }

    public ApiResult<Void> isStandard(String code, HttpSession session, Account account) {
        // 判断验证码
        if (!session.getAttribute("code").equals(code.toLowerCase())) {
            return ApiResult.failed("验证码错误");
        }
        session.removeAttribute("code");

        // 判断 账号 密码 邮箱 是否符合
        if (!registerService.isStandard(account)) {
            return ApiResult.failed("账号密码不符合");
        }
        return null;
    }

    /**
     * 查询是否有重名
     * 
     * @param name 用户名
     * @return 结果
     */
    public ApiResult<Void> searchName(String name) {
        if (StrUtil.isNotBlank(name)) {
            registerService.searchAccount(name);
        }

        return ApiResult.success();
    }

    public ApiResult<Boolean> searchAccount(String account) {
        return ApiResult.success(registerService.searchAccount(account));
    }

}
