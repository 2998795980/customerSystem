package com.crm.dao.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crm.common.CommonConstant;
import com.crm.common.context.PersonContext;
import com.crm.common.context.PersonContextHolder;
import com.crm.dao.entity.Company;
import com.crm.dao.mapper.CompanyMapper;
import com.crm.dao.service.ICompanyService;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 客户公司表 服务实现类
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Resource
    CompanyMapper companyMapper;

    @Override
    public List<Company> findAll() {
        // 判断是否登录
        PersonContext personContext = PersonContextHolder.getPersonContext();
        if (ObjectUtil.isNull(personContext)) {
            return List.of();
        }
        QueryWrapper<Company> qWrapper = new QueryWrapper<>();
        qWrapper.eq("state", CommonConstant.ACTIVE_STATE);
        qWrapper.eq(ObjectUtil.isNotNull(personContext.getAccountId()), "created_by", personContext.getAccountId());
        return companyMapper.selectList(qWrapper);
    }

    @Override
    public Company findByCompanyId(String companyId) {
        return companyMapper
            .selectOne(lambdaQuery().eq(StrUtil.isNotBlank(companyId), Company::getCompanyId, companyId));
    }

    @Override
    public void create(Company company) {
        // 判断是否登录
        PersonContext personContext = PersonContextHolder.getPersonContext();
        if (ObjectUtil.isNull(personContext)) {
            return;
        }
        Integer accountId = personContext.getAccountId();
        company.setCreatedTime(LocalDateTime.now());
        company.setCreatedBy(accountId);
        companyMapper.insert(company);
    }

    @Override
    public void delete(Company company) {
        PersonContext personContext = PersonContextHolder.getPersonContext();
        if (ObjectUtil.isNull(personContext)) {
            return;
        }
        company.setState(CommonConstant.ARCHIVE);
        company.setUpdatedTime(LocalDateTime.now());
        company.setUpdatedBy(personContext.getAccountId());
        companyMapper.updateById(company);
    }
}
