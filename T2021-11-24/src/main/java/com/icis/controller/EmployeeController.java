package com.icis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icis.pojo.Employee;
import com.icis.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

public class EmployeeController {


    private IEmployeeService employeeService;

    // 注入一个Json 工具

    private ObjectMapper objectMapper;


    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // 定义方法  返回一个json 员工对象字符串
    public String  findOne(Integer empId){
        employeeService.show();

        Employee employee = this.employeeService.findOne(empId);
        // 转换为json
        String empJsonStr = null;
        try {
            empJsonStr = this.objectMapper.writeValueAsString(employee);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  empJsonStr;

    }
}
