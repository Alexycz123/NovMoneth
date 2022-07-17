package com.ycz.service.impl;/*
 @author ycz
 @date 2021-11-22-10:23
*/

import com.ycz.dao.UserMapper;
import com.ycz.pojo.User;
import com.ycz.service.UserService;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SqlSession getSqlSession;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String add() {
        return userMapper.add();
    }

    @Override
    public List<User> selectList() {
        Configuration configuration = sqlSessionFactory.getConfiguration();
        System.out.println(configuration);
        UserMapper mapper = getSqlSession.getMapper(UserMapper.class);

        return mapper.selectList();
    }
}
