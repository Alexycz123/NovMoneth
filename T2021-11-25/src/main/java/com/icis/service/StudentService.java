package com.icis.service;

import com.icis.pojo.PageBean;

// 学生接口
public interface StudentService {
    // 定义方法 根据当前页  获得对应的页面数据
    // 要求  把通用的代码  写成通知
    /*
    * 1. 根据当前页获得  起始索引
    * 2. 查询总记录数
    * 3. 查询总页数
    *
    * Spring 解决 耦合性问题
    * 1. IOC 解决的是 Comoment 和Component 之间的依赖关系 工厂Factory
    * 2. AOP 解决的是  程序之间的耦合性问题  动态代理
    * */
    public PageBean getStudentByPage(int currentPage,int pageSize);
}
