package com.crm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.dao.entity.Account;
import com.crm.dao.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    AccountMapper accountMapper;

    public boolean isStandard(Account account) {
        // 判断标准
        return true;
    }

    public Account login(Account login) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("account",login.getAccount())
                .eq("password",login.getPassword());
        return accountMapper.selectOne(wrapper);
    }
}
