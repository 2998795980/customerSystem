package com.crm.dao.service.impl;

import com.crm.bean.Permissions;
import com.crm.bean.Role;
import com.crm.dao.entity.Account;
import com.crm.dao.mapper.AccountMapper;
import com.crm.dao.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.util.List;

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

    @Autowired
    AccountMapper accountMapper;

    @Transactional
    public Role getRoleById(@NotBlank Integer id) {
        Integer roleId = accountMapper.getRoleIdByAccountId(id);
        return accountMapper.getRoleByRoleId(roleId);
    }

    @Transactional
    public List<Permissions> getPermissionsById(@NotBlank Integer id) {
        Integer roleId = accountMapper.getRoleIdByAccountId(id);
        Role role = accountMapper.getRoleByRoleId(roleId);
        List<Integer> permissionsId = accountMapper.getPermissionsIdByRoleId(role.getId());
        return accountMapper.getPermissionsByPermissionId(permissionsId);
    }
}
