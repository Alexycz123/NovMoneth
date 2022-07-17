package com.ycz.controller;/*
 @author ycz
 @date 2021-11-29-9:19
*/

import com.ycz.pojo.Account;
import com.ycz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    public Account getOne(Integer id){
        return accountService.getOne(id);
    }

    public List<Account> getAll(){
        return accountService.queryAll();
    }

    public Object update(Integer inId,Integer outId,double money){
        Object update = accountService.update(inId, outId, money);

        return update;
    };
}
