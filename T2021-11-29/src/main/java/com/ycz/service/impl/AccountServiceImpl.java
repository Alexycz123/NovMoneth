package com.ycz.service.impl;/*
 @author ycz
 @date 2021-11-29-9:05
*/

import com.ycz.dao.AccountDao;
import com.ycz.pojo.Account;
import com.ycz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    public List<Account> queryAll() {
        return accountDao.queryAll();
    }

    public Account getOne(Integer id){
        return accountDao.getOne(id);
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,isolation = Isolation.DEFAULT )
    public Object update(Integer inId, Integer outId, double money) {
        Account in = accountDao.getOne(inId);
        double inMoney=in.getMoney()+money;
        Account out=accountDao.getOne(outId);
        double outMoney=out.getMoney()-money;

        Integer result1 = accountDao.update(inId, inMoney);

        Integer i=1/0;
        Integer result2 = accountDao.update(outId, outMoney);

        return result1+result2;

    }
}
