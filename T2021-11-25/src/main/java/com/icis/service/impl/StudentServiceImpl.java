package com.icis.service.impl;

import com.icis.pojo.PageBean;
import com.icis.service.StudentService;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;

@Service
public class StudentServiceImpl implements StudentService{
    @Override
    public PageBean getStudentByPage(int currentPage,int pageSize) {
        // 执行分页
        //
        return null;
    }
}
