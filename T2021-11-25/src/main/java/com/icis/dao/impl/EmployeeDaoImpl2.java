package com.icis.dao.impl;

import com.icis.dao.IEmployeeDao;
import com.icis.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl2 implements IEmployeeDao{
    // 定义 jdbcTemplate
    @Autowired
    private JdbcTemplate template;



    @Override
    public Employee findOne(Integer empId) {
        String sql="SELECT * FROM `emp` where id=?";
        List<Employee> employeeList = this.template.query(sql, new BeanPropertyRowMapper<>(Employee.class),empId);
        System.out.println(employeeList);
        return employeeList!=null?employeeList.get(0):null;
    }
}
