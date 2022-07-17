package com.ycz.service;/*
 @author ycz
 @date 2021-11-08-18:18
*/

import com.ycz.pojo.User;
import com.ycz.query.UserQuery;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    User selectById_pwd(User user);

    List<User> selectUserList(UserQuery query);

    Integer insertUser(User user);

    User selectById(int id);

    Integer updateUserById(User user);

    Integer deleteById(String id);

    Integer selectCount(UserQuery userQuery);

    Integer deleteBatchById(ArrayList<Integer> lists);

    User selectByName(String name);

    Integer restoreAll();
}
