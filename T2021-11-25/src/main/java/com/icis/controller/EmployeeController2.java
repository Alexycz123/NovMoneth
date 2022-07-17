package com.icis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icis.pojo.Employee;
import com.icis.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController2 {
    @Autowired
    private IEmployeeService employeeService;

    // 注入一个Json 工具
    @Autowired
    private ObjectMapper objectMapper;



    // 定义方法  返回一个json 员工对象字符串
    public String  findOne(Integer empId){
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
