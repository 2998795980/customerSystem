package com.crm.utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import org.springframework.stereotype.Component;

@Component
public class CaptchaGenerate {

    public ICaptcha RandomSelectMethod() {
        int random = (int) (Math.random() * 5) + 1;
        switch(random) {
            case 1: return lineCaptcha();
            case 2: return circleCaptcha();
            case 3: return shearCaptcha();
//            case 4: return operationCaptcha();
            case 5: return randomNumberCaptcha();
        }
        return lineCaptcha();
    }

    /**
     * LineCaptcha 线段干扰的验证码
     *
     * @return ICaptcha对象
     */
    public ICaptcha lineCaptcha() {
        //定义图形验证码的长和宽
        return CaptchaUtil.createLineCaptcha(200, 100);
    }

    /**
     * CircleCaptcha 圆圈干扰验证码
     * @return ICaptcha对象
     */
    public ICaptcha circleCaptcha() {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        return CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
    }

    /**
     * ShearCaptcha 扭曲干扰验证码
     * @return ICaptcha对象
     */
    public ICaptcha shearCaptcha() {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        return CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
    }

    /**
     * 四则运算验证码
     * @return ICaptcha
     */
    public ICaptcha operationCaptcha() {
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(200, 45, 4, 4);
        shearCaptcha.setGenerator(new MathGenerator());
        shearCaptcha.createCode();
        return shearCaptcha;
    }

    public ICaptcha randomNumberCaptcha() {
        // 自定义纯数字的验证码（随机4位数字，可重复）
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.setGenerator(randomGenerator);
        lineCaptcha.createCode();
        return lineCaptcha;
    }
}
