package com.crm.dao.service.impl;

import com.crm.dao.entity.Account;
import com.crm.dao.mapper.AccountMapper;
import com.crm.dao.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号表 服务实现类
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
