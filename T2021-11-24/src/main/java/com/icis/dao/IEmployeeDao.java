package com.icis.dao;

import com.icis.pojo.Employee;

public interface IEmployeeDao {
    // 定义方法  根据id  返回一个 员工
    public Employee findOne(Integer empId);
}
