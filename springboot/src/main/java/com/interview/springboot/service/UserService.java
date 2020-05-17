package com.interview.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addUser(String name, String age) {
        int update = jdbcTemplate.update("insert into users values (null, ?, ?)", name, age);
        return update;
    }
}
