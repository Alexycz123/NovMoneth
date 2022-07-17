package com.icis.dao.impl;

import com.icis.dao.IEmployeeDao;
import com.icis.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao{
    // 定义 jdbcTemplate

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Employee findOne(Integer empId) {
        String sql="SELECT * FROM `emp` WHERE id=?";
        List<Employee> employeeList = this.template.query(sql, new BeanPropertyRowMapper<>(Employee.class), empId);
        return employeeList!=null?employeeList.get(0):null;
    }
}
