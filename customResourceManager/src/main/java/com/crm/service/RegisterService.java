package com.crm.service;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.dao.entity.Account;
import com.crm.dao.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    AccountMapper accountMapper;


    /**
     * 插入一个用户
     * @param account 用户信息
     */
    public void insertAccount(Account account){
        accountMapper.insert(account);
    }

    /**
     * 查询是否有重名的用户名
     * @param username 用户名
     * @return 是否重名
     */
    public boolean searchUsername(String username) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username)
                .ne("state",-1);
        Long aLong = accountMapper.selectCount(wrapper);
        return aLong <= 0;
    }

    /**
     * 查询是否有重名的账号
     * @param account 账号
     * @return 是否重名
     */
    public boolean searchAccount(String account) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("account",account)
                .ne("state",-1);
        Long aLong = accountMapper.selectCount(wrapper);
        return aLong <= 0;
    }

    /**
     * 判断 用户名 密码 邮箱 是否符合规范
     * @param account 用户信息
     * @return 是否规范
     */
    public boolean isStandard(Account account) {

        return true;
    }


}
