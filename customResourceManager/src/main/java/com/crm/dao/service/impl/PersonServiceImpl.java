package com.crm.dao.service.impl;

import com.crm.dao.entity.Person;
import com.crm.dao.mapper.PersonMapper;
import com.crm.dao.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author yuzhe
 * @since 2022-10-12
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
