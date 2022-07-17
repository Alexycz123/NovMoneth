package com.ycz.service;/*
 @author ycz
 @date 2021-11-29-9:05
*/

import com.ycz.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> queryAll();

    Account getOne(Integer id);


    Object update(Integer inId, Integer outId, double money);
}
