package com.crm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 封装响应体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    /**
     * 状态码
     */
    public Integer statusCode;

    /**
     * 响应结果（成功 or 失败）
     */
    public String result;

    /**
     * 数据
     */
    public Object data;

    /**
     * 封装
     * 状态码 响应结果
     */
    public static final Integer STATUS_SUCCESS = 200;
    public static final Integer STATUS_FAIL = 400;

    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FAIL = "fail";
}
