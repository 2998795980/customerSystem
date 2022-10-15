package com.crm.controller.company;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.crm.common.ApiResult;
import com.crm.dao.entity.Company;
import com.crm.dao.service.ICompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private ICompanyService service;

    @GetMapping("/all")
    // TODO 待授权
    public ApiResult<List<Company>> findAll() {
        // 判断是否有没有登录 如果没有登陆则不进行显示
        List<Company> companyList = service.findAll();
        return ApiResult.success(companyList);
    }

    @PostMapping("")
    public ApiResult<Void> create(@RequestBody @Validated CompanyForm companyForm) {
        // 创建客户公司 TODO 要保证接口幂等性
        Company company = companyForm.copyCompany(new Company());
        service.create(company);
        return ApiResult.success();
    }

    @PutMapping("/{id}")
    public ApiResult<Void> update(@PathVariable("id") Long id, @RequestBody @Validated CompanyForm companyForm) {
        // 先查询是否存在
        return ApiResult.success();
    }

    @DeleteMapping("/{id}")
    public ApiResult<Void> delete(@PathVariable("id") Long id) {
        return ApiResult.success();
    }

}
