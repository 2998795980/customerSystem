package com.crm.dao.mapper;

import com.crm.bean.Permissions;
import com.crm.bean.Role;
import com.crm.dao.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 账号表 Mapper 接口
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
@Repository
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 通过用户id获取规则id
     * @param accountID 用户id
     * @return 规则id
     */
    Integer getRoleIdByAccountId(@Param("accountID") Integer accountID);

    /**
     * 通过规则id获取权限id
     * @param roleID 规则id
     * @return 权限id
     */
    List<Integer> getPermissionsIdByRoleId(@Param("roleId") Integer roleID);

    /**
     * 通过规则id获取规则
     * @param roleId 规则id
     * @return 获取规则对象
     */
    Role getRoleByRoleId(@Param("roleId") Integer roleId);

    List<Permissions> getPermissionsByPermissionId(@Param("permissionsId") List<Integer> permissionsId);

}
