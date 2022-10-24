package com.crm.test;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ReUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RandomTest {

    @Test
    public void randomTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 5) +1);
        }
    }

    @Test
    public void byteTest() {
        byte[] s1 = {'1','b','c'};
        System.out.println(new String(s1,0,s1.length));
    }

    @Test
    public void dataTime() {
        String str = "12313";
        boolean match = ReUtil.isMatch("[0123456789]+", str);
        System.out.println(match);
    }
}
