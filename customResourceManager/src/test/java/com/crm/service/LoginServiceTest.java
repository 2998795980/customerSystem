package com.crm.service;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.dao.entity.Account;
import com.crm.dao.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoginServiceTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    void login() {
//        new Consume

//        Account login = new Account("root", "123456");
//        login.setState(1);

        Account login = new Account();
        login.setUsername("Fool");
        login.setAccount("root");
        login.setPassword("123456");
        login.setState(1);
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username",login.getUsername())
                .eq("account",login.getAccount())
                .eq("password",login.getPassword())
                .eq("state",login.getState());



        System.out.println(accountMapper.selectOne(wrapper));
    }
}