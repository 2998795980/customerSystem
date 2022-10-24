package com.crm.dao.service;

import com.crm.bean.Permissions;
import com.crm.bean.Role;
import com.crm.dao.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * 账号表 服务类
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
public interface IAccountService extends IService<Account> {

    /**
     * 通过用户ID 获取 规则ID
     * @param id 用户ID
     * @return Role对象
     */
    public Role getRoleById(@NotBlank Integer id);

    public List<Permissions> getPermissionsById(@NotBlank Integer id);
}
