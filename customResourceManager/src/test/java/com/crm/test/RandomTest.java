package com.crm.test;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
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
        System.out.println(DateUtil.date(System.currentTimeMillis()).toString());

        System.out.println(DateUtil.now());
//        System.out.println(LocalDateTime.now().format("yyyy-MM-dd HH:mm:ss"));

//        System.out.println(LocalDateTimeUtil);
    }
}
