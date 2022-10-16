package com.crm.controller.company;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.crm.dao.entity.Company;
import com.crm.dao.service.ICompanyService;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 客户公司校验
 */
@Component
public class CompanyValidator {
    @Resource
    ICompanyService service;

    /**
     * 根据公司id校验公司是否存在
     * 
     * @param id
     * @return
     */
    public Company validateCompanyExist(Long id) {
        Company company = service.getById(id);
        if (ObjectUtil.isNull(company)) {
            throw new IllegalArgumentException("客户公司id不存在");
        }
        return company;
    }

    /**
     * 根据公司id查询公司是否存在
     * 
     * @param companyId
     * @return
     */
    public Company validateExistByCompanyId(String companyId) {
        if (StrUtil.isBlank(companyId)) {
            return null;
        }
        return service.findByCompanyId(companyId);
    }
}
