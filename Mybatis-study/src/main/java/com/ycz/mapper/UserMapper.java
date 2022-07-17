package com.ycz.mapper;/*
 @author ycz
 @date 2021-11-29-15:03
*/

import com.ycz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    User selectOne(@Param("id") int id);

    Integer updateUser(User user);

    Integer insertBatchUser(@Param("userList") List<User> userList);
}
