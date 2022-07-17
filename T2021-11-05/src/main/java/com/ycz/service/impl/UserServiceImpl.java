package com.ycz.service.impl;/*
 @author ycz
 @date 2021-11-08-18:18
*/

import com.ycz.mapper.UserMapper;
import com.ycz.pojo.User;
import com.ycz.query.UserQuery;
import com.ycz.service.UserService;
import com.ycz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final SqlSession sqlSession=MybatisUtils.getSqlSession();

    @Override
    public User selectById_pwd(User user) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectById_pwd(user);
    }

    @Override
    public List<User> selectUserList(UserQuery query) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUserList(query);
    }

    @Override
    public Integer insertUser(User user) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer i=mapper.insertUser(user);
        sqlSession.commit();
        return i;

    }

    @Override
    public User selectById(int id) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectById(id);
    }

    @Override
    public Integer updateUserById(User user) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer i=mapper.updateUserById(user);
        sqlSession.commit();
        return i;
    }

    @Override
    public Integer deleteById(String id) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer i=mapper.deleteById(Integer.parseInt(id));
        sqlSession.commit();
        return i;
    }

    @Override
    public Integer selectCount(UserQuery userQuery) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectCount(userQuery);
    }

    @Override
    public Integer deleteBatchById(ArrayList<Integer> ids) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       Integer i= mapper.deleteBatchById(ids);
       sqlSession.commit();
       return i;
    }

    @Override
    public User selectByName(String name) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectByName(name);
    }

    @Override
    public Integer restoreAll() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer i=mapper.restoreAll();
        sqlSession.commit();
        return i;
    }


}
