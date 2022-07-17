package com.ycz.service.impl;/*
 @author ycz
 @date 2021-11-11-15:26
*/

import com.ycz.mapper.ProvinceMapper;
import com.ycz.pojo.Province;
import com.ycz.service.ProvinceService;
import com.ycz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private static final  SqlSession sqlSession = MybatisUtils.getSqlSession();

    @Override
    public List<Province> selectList() {

        ProvinceMapper mapper = sqlSession.getMapper(ProvinceMapper.class);

        return mapper.selectList();
    }
}
