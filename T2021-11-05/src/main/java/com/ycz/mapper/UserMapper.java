package com.ycz.mapper;/*
 @author ycz
 @date 2021-11-02-18:22
*/

import com.ycz.pojo.User;
import com.ycz.query.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper {

    User selectById_pwd(User user);

    List<User> selectUserList(UserQuery query);

    Integer insertUser(User user);

    User selectById(int id);

    Integer updateUserById(User user);

    Integer deleteById(int parseInt);

    Integer selectCount(UserQuery userQuery);

    Integer deleteBatchById(@Param("ids") ArrayList<Integer> ids);

    User selectByName(@Param("name") String name);

    Integer restoreAll();
}
