package com.crm.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;

import java.util.HashMap;


public class JWTUtils {

    private final static JWTSigner key = JWTSignerUtil.hs256("asdfghjkl".getBytes());

    public static String createToken(HashMap<String, Object> data) {
        return JWTUtil.createToken(data, key);
    }

    public static String parsePayload(String token,String payload) {
        JWT jwt = JWTUtil.parseToken(token);
        String data = (String) jwt.getPayload(payload);
        return data;
    }

    public static boolean verifyToken(String token) {
        return JWTUtil.verify(token,key);
    }

}


