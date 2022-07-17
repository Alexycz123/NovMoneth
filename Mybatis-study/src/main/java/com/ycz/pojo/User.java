package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-29-14:58
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private Integer id; // 用户id
    private String username; // 用户名
    private String birthday; // 出生日期
    private String sex; // 性别
    private String address; // 家庭住址

}
