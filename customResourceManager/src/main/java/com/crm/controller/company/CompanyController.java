package com.crm.controller.company;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.crm.common.ApiResult;
import com.crm.dao.entity.Company;
import com.crm.dao.service.ICompanyService;

import cn.hutool.core.util.ObjectUtil;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private ICompanyService service;
    @Resource
    private CompanyValidator companyValidator;

    @GetMapping("/all")
    // TODO 待授权
    public ApiResult<List<Company>> findAll() {
        // 判断是否有没有登录 如果没有登陆则不进行显示
        List<Company> companyList = service.findAll();
        return ApiResult.success(companyList);
    }

    @GetMapping("/{id}")
    public ApiResult<Company> findById(@PathVariable("id") Long id) {
        Company company = companyValidator.validateCompanyExist(id);
        return ApiResult.success(company);
    }

    @PostMapping("")
    public ApiResult<Void> create(@RequestBody @Validated CompanyForm companyForm) {
        Company company = companyValidator.validateExistByCompanyId(companyForm.getCompanyId());
        companyForm.copyCompany(company);
        // 保证幂等性
        if (ObjectUtil.isNotNull(company.getId())) {
            service.updateById(company);
        } else {
            service.create(company);
        }
        return ApiResult.success();
    }

    @PutMapping("/{id}")
    public ApiResult<Void> update(@PathVariable("id") Long id, @RequestBody @Validated CompanyForm companyForm) {
        // 先查询是否存在
        Company company = companyValidator.validateCompanyExist(id);
        companyForm.copyCompany(company);
        service.updateById(company);
        return ApiResult.success();
    }

    @DeleteMapping("/{id}")
    public ApiResult<Void> delete(@PathVariable("id") Long id) {
        // 根据id校验公司是否存在
        Company company = companyValidator.validateCompanyExist(id);
        service.delete(company);
        return ApiResult.success();
    }

}
