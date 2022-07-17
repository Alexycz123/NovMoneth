package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-02-18:23
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String gender;
    private String qq;
    private Integer age;
    private String address;
    private String email;


}
