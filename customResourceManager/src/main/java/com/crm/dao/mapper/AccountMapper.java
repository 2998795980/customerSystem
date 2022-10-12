package com.crm.dao.mapper;

import com.crm.dao.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

}
