package com.ycz.controller;/*
 @author ycz
 @date 2021-11-22-15:00
*/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycz.pojo.User;
import com.ycz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add(){
        String add = userService.add();
        System.out.println(add);
    }

    public Object selectList() throws JsonProcessingException {

         return  objectMapper.writeValueAsString(userService.selectList());
    }
}
