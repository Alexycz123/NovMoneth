package com.icis.service.impl;

import com.icis.dao.IEmployeeDao;
import com.icis.pojo.Employee;
import com.icis.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class EmployeeServiceImpl implements IEmployeeService{
    // 定义个dao

    private IEmployeeDao employeeDao;

    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee findOne(Integer empId) {
        return this.employeeDao.findOne(empId);
    }

    @Override
    public void show() {
        System.out.println("执行了show方法");
    }
}
