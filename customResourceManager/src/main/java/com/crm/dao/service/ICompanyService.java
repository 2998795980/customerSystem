package com.crm.dao.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crm.dao.entity.Company;

/**
 * <p>
 * 客户公司表 服务类
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
public interface ICompanyService extends IService<Company> {

    /**
     * 查询全部公司
     * 
     * @return
     */
    List<Company> findAll();

    /**
     * 创建客户公司
     * 
     * @param company
     */
    void create(Company company);
}
