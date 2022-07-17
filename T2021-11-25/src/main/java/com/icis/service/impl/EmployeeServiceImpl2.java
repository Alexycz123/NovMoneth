package com.icis.service.impl;

import com.icis.dao.IEmployeeDao;
import com.icis.pojo.Employee;
import com.icis.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl2 implements IEmployeeService{
    // 定义个dao
    @Autowired
    private IEmployeeDao employeeDao;



    @Override
    public Employee findOne(Integer empId) {
        // aop 编程  记录 查询的数据 emp id
        Employee emp = this.employeeDao.findOne(empId);
         //int i=1/0;
        System.out.println("service 层 findOne");
        return  emp;
    }
}
