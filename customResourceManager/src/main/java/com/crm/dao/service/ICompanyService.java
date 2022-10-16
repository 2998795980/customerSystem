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
     * 通过公司id查询公司
     * 
     * @param companyId
     * @return
     */
    Company findByCompanyId(String companyId);

    /**
     * 创建客户公司
     * 
     * @param company
     */
    void create(Company company);

    /**
     * 删除客户公司
     * 
     * @param company
     */
    void delete(Company company);

}
