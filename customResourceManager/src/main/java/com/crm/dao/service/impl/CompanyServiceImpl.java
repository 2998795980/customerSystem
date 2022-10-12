package com.crm.dao.service.impl;

import com.crm.dao.entity.Company;
import com.crm.dao.mapper.CompanyMapper;
import com.crm.dao.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
