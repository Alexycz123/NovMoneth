package com.ycz.dao;/*
 @author ycz
 @date 2021-11-29-9:04
*/

import com.ycz.pojo.Account;

import java.util.List;

public interface AccountDao {
    List<Account> queryAll();

    Account getOne(Integer id);

    Integer update(Integer inId, double inMoney);
}
