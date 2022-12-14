package com.crm.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.dao.mapper.PersonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class MySQLTest {

    @Autowired
    PersonMapper personMapper;


    @Test
    public void personMapperTest() {
        Long aLong = personMapper.selectCount(new QueryWrapper<>());
        System.out.println(aLong);
    }


}
