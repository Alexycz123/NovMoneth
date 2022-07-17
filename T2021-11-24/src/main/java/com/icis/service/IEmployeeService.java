package com.icis.service;

import com.icis.pojo.Employee;

public interface IEmployeeService {
    // 定义方法  根据id  返回一个 员工
    public Employee findOne(Integer empId);

    void show();
}
