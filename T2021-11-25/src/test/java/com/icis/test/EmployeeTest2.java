package com.icis.test;

import com.icis.config.SpringConfiguration;
import com.icis.controller.EmployeeController2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 员工测试类
// 替换运行容器  junitRunner --->SpringJUnit4ClassRunner
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class EmployeeTest2 {
    @Autowired
    private EmployeeController2 employeeController;

    @Test
    public void findOneTest1(){
        String jsonEmp = this.employeeController.findOne(3);
        System.out.println("结果是:"+jsonEmp);

    }
}
