package com.crm.controller.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.common.ApiResult;
import com.crm.dao.entity.Account;
import com.crm.dao.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AccountControllerTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void testFind() {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username","Fool");
        Account find = accountMapper.selectOne(wrapper);
        System.out.println(find);
    }

}