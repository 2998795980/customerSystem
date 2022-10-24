package com.crm.service;

import cn.hutool.core.util.ReUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.dao.entity.Account;
import com.crm.dao.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
        // 判断标准
        HashMap<String,String> role = new HashMap<>() {
            {
                // 帐号是否合法(字母开头，允许6-16字节，允许字母数字下划线)：^[a-zA-Z][a-zA-Z0-9_]{4,15}$
                put("account","^[a-zA-Z][a-zA-Z0-9_]{5,15}$");
                // 密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)：^[a-zA-Z]\w{5,17}$
                put("password","^[a-zA-Z]\\w{5,17}$");
                // Email地址 ^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
                put("email","^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
            }
        };
        boolean accountResult = ReUtil.isMatch(role.get("account"), account.getAccount());
        boolean passwordResult = ReUtil.isMatch(role.get("password"), account.getPassword());
        boolean emailResult = ReUtil.isMatch(role.get("email"), account.getEmail());
        return (accountResult && passwordResult) || (emailResult && passwordResult);
    }


}
