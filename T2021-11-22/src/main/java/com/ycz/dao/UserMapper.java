package com.ycz.dao;/*
 @author ycz
 @date 2021-11-22-14:57
*/

import com.ycz.pojo.User;

import java.util.List;

public interface UserMapper {

    String add();

    List<User> selectList();
}
