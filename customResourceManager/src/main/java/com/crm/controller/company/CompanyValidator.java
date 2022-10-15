package com.crm.controller.company;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.crm.dao.service.ICompanyService;

/**
 * 客户公司校验
 */
@Component
public class CompanyValidator {
    @Resource
    ICompanyService service;

}
