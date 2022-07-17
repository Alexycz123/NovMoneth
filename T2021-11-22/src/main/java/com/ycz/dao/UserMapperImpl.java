package com.ycz.dao;/*
 @author ycz
 @date 2021-11-22-14:58
*/

import com.ycz.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMapperImpl implements UserMapper{
    @Override
    public String add() {
        return "userDAO" +
                "add方法";
    }

    @Override
    public List<User> selectList() {
        return null;
    }
}
