package com.crm.controller.account;

import cn.hutool.core.util.ReUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.crm.bean.Permissions;
import com.crm.bean.Role;
import com.crm.common.ApiResult;
import com.crm.dao.entity.Account;
import com.crm.dao.mapper.AccountMapper;
import com.crm.dao.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    IAccountService accountService;
    @Autowired
    AccountMapper accountMapper;

    @GetMapping("findAccount/{idOrUserName}")
    public ApiResult<Account> findAccountByName(@PathVariable("idOrUserName") @NotBlank String idOrUserName) {
        Account find;
        if(ReUtil.isMatch("[0123456789]+", idOrUserName)) {
            find = accountMapper.selectById(Integer.parseInt(idOrUserName));
        }else {
            QueryWrapper<Account> wrapper = new QueryWrapper<>();
            wrapper.eq("username",idOrUserName);
            find = accountMapper.selectOne(wrapper);
        }
        if(find != null) {
            return ApiResult.success(find);
        }

        return ApiResult.failed();
    }

    /**
     *
     * @param id 用户ID
     * @return Role对象
     */
    @GetMapping("role")
    public ApiResult<Role> findRole(Integer id) {
        Role role = accountService.getRoleById(id);
        return ApiResult.success(role);
    }

    /**
     *
     * @param id 用户对象
     * @return Permissions对象
     */
    @GetMapping("permissions")
    public ApiResult<List<Permissions>> getPermissions(Integer id) {
        List<Permissions> permissions = accountService.getPermissionsById(id);
        return ApiResult.success(permissions);
    }

    @PostMapping("update")
    public ApiResult<String> updatePasswordByPassword(Account account) {
        UpdateWrapper<Account> wrapper = new UpdateWrapper<>();
        wrapper.eq("account",account.getAccount()).set("password", account.getPassword());
        accountService.update(wrapper);
        return ApiResult.success();
    }

    @PostMapping("logout")
    public ApiResult<String> logoutAccount(Account account) {
        UpdateWrapper<Account> wrapper = new UpdateWrapper<>();
        wrapper.eq("account",account.getAccount()).set("state",-1);
        accountService.update(wrapper);
        return ApiResult.success();
    }
}
