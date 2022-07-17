package com.icis.test;

import com.icis.controller.EmployeeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 员工测试类
// 替换运行容器  junitRunner --->SpringJUnit4ClassRunner
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicatonContext.xml")
public class EmployeeTest {
    @Autowired
    private EmployeeController employeeController;

    @Test
    public void t1(){
        String one = employeeController.findOne(2);
        System.out.println(one);
    }

}
