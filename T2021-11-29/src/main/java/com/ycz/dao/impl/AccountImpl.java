package com.ycz.dao.impl;/*
 @author ycz
 @date 2021-11-29-9:04
*/

import com.ycz.dao.AccountDao;
import com.ycz.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> queryAll() {
        String sql="select * from account";
        List<Account> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));


        return query;
    }

    @Override
    public Account getOne(Integer id) {
        String sql="select * from account where id=?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), id);

        return account;
    }

    @Override
    public Integer update(Integer inId, double inMoney) {
        return jdbcTemplate.update("update account set money=? where id=?",inMoney,inId);

    }
}
